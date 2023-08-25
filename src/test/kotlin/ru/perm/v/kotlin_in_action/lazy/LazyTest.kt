package ru.perm.v.kotlin_in_action.lazy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.concurrent.atomic.AtomicInteger

class LazyTest {
    @Test
    fun givenLazyValue_whenGetIt_thenShouldInitializeItOnlyOnce() {
        // given
        val numberOfInitializations: AtomicInteger = AtomicInteger()
        val lazyValue: ClassWithHeavyInitialization by lazy {
            numberOfInitializations.incrementAndGet()
            ClassWithHeavyInitialization()
        }
        // when
        println(numberOfInitializations)
        println(lazyValue)
        println(numberOfInitializations)
        println(lazyValue)

        // then
        assertEquals(1, numberOfInitializations.get())
    }
}