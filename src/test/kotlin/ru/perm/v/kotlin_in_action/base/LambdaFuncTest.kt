package ru.perm.v.kotlin_in_action.base

import ru.perm.v.kotlin_in_action.PersonK

class LambdaFuncTest {
    val persons = listOf(
        PersonK(1, "NAME1", 10),
        PersonK(2, "NAME2", 20),
        PersonK(-1, "NAME-1", null)
    )

//    fun findAlice() = findPerson{ it.name == "Alice"}

    private fun findPerson(function: () -> Boolean): Int {
        return 0
    }

}