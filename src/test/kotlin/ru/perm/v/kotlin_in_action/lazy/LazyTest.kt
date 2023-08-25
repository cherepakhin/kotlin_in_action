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

        // lazy инициализация: "by lazy" ключевое выражение.
        // инициализация lazValue = ClassWithHeavyInitialization() будет вызвано при первом обращении к lazyValue
        val lazyValue: ClassWithHeavyInitialization by lazy {
            numberOfInitializations.incrementAndGet()
            ClassWithHeavyInitialization()
        }
        // when
        // еще не было обращения к значению lazyValue,
        // и lazyValue еще не был инициализирован
        // >start numberOfInitializations: 0
        println(format("start numberOfInitializations: %s",numberOfInitializations.get()))

        println(format("lazyValue: %s",lazyValue)) //lazyValue: ru.perm.v.kotlin_in_action.lazy.ClassWithHeavyInitialization@184fb68d
        // >after get first lazyValue, numberOfInitializations: 1
        println(format("after get first lazyValue, numberOfInitializations: %s",numberOfInitializations.get()))

        // >start numberOfInitializations: 1
        println(format("lazyValue: %s",lazyValue)) //lazyValue: ru.perm.v.kotlin_in_action.lazy.ClassWithHeavyInitialization@184fb68d
        // >after get first lazyValue, numberOfInitializations: 1
        println(format("after second get lazyValue, numberOfInitializations: %s",numberOfInitializations.get()))

        // then
        assertEquals(1, numberOfInitializations.get())
    }
}