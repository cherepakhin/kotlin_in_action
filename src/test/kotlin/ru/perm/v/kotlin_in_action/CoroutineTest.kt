package ru.perm.v.kotlin_in_action

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CoroutineTest {
    // Основной класс User(name: String, friends: List<Friend>, profile: Profile)
    class Friend(name: String) {}

    class Profile(name: String) {}

    class MyRepo {
        fun getName(): String {
            return "NAME"
        }

        fun getFriends(): List<Friend> {
            return listOf(Friend("FRIENDS"))
        }

        fun getProfile(): Profile {
            return Profile("PROFILE")
        }
    }

    class User(name: String, friends: List<Friend>, profile: Profile) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is User) return false
            return true
        }

        override fun hashCode(): Int {
            return javaClass.hashCode()
        }
    }

    class FetchUserUseCase(
        private val repo: MyRepo = MyRepo()
    ) {

        suspend fun fetchUserData(): User = coroutineScope {
            val name = async { repo.getName() }
            val friends = async { repo.getFriends() }
            val profile = async { repo.getProfile() }
            User(
                name = name.await(),
                friends = friends.await(),
                profile = profile.await()
            )
        }
    }

    @Test
    fun `should construct user`() = runBlocking {
        // given
        val repo = MyRepo()
        val useCase = FetchUserUseCase(repo)

        // when
        val result = useCase.fetchUserData()

        // then
        val friend = Friend("some-friend-id-1")
        val expectedUser = User(
            name = "Ben",
            friends = listOf(friend),
            profile = Profile("Example description")
        )
        assertEquals(expectedUser, result)
    }
}