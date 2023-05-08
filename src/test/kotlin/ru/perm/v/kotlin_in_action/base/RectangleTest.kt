package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RectangleTest {
    class Rectangle(val length: Int = 0, val width: Int) {

        val isSquireProp: Boolean
            get() {
                return length.equals(width)
            }

        val isSquireShortProp
            get() = length.equals(width)

        fun isSquireFun(): Boolean {
            return length.equals(width)
        }
    }

    @Test
    internal fun isKvadrat() {
        Assertions.assertTrue(Rectangle(5, 5).isSquireFun())
    }

    @Test
    internal fun isNotKvadrat() {
        val rect = Rectangle(1, 5)
        // Везде обращение как к полям
        // rect.length
        // rect.width
        // rect.isSquireProp
        // обращение к свойству isSquireProp через метод get, в отличие от прямого обращения к переменной
        // в примере выше обращение к методу isSquireFun(), а тут как к СВОЙСТВУ val a = rect.isSquireProp
        assertFalse(rect.isSquireProp)
        assertFalse(rect.isSquireShortProp)
        assertTrue(rect.length.equals(1))
        assertTrue(rect.width.equals(5))

    }
}