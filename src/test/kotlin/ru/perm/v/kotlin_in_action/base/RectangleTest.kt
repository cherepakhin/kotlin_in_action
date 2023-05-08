package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class RectangleTest {
    class Rectangle(val length: Int = 0, val width: Int) {
        fun isSquire(): Boolean {
            return length.equals(width)
        }

        val isSquireProp: Boolean
            get() {
                return length.equals(width)
            }
    }

    @Test
    internal fun isKvadrat() {
        Assertions.assertTrue(Rectangle(5, 5).isSquire())
    }

    @Test
    internal fun isNotKvadrat() {
        Assertions.assertFalse(Rectangle(1, 5).isSquireProp)
    }
}