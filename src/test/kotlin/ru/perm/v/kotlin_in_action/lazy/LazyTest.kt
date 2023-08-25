package ru.perm.v.kotlin_in_action.lazy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.lang.String.format
import java.util.concurrent.atomic.AtomicInteger

class LazyTest {
    @Test
    fun givenLazyValue_whenGetIt_thenShouldInitializeItOnlyOnce() {
        // given
        val numberOfInitializations: AtomicInteger = AtomicInteger()

        // обычная инициализация:
        // val ss = ClassWithHeavyInitialization()

//        println(numberOfInitializations)
        // lazy инициализация:
        val lazyValue: ClassWithHeavyInitialization by lazy {
            numberOfInitializations.incrementAndGet()
            ClassWithHeavyInitialization()
        }
        // when
        println(format("start numberOfInitializations: %s",numberOfInitializations.get()))

        println(format("lazyValue: %s",lazyValue))
        println(format("after get first lazyValue, numberOfInitializations: %s",numberOfInitializations.get()))

        println(format("lazyValue: %s",lazyValue))
        println(format("after second get lazyValue, numberOfInitializations: %s",numberOfInitializations.get()))

        // then
        assertEquals(1, numberOfInitializations.get())
    }
}