package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ReturnTest {
    class MyMaxFunc {
        fun getMax(a: Int, b: Int): Int {
            return if (a > b) a else b
        }
    }

    @Test
    fun maxTest() {
        Assertions.assertEquals(5, MyMaxFunc().getMax(5, 4))
    }
}