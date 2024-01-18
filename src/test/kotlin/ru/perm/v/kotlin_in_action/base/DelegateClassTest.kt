package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DelegateClassTest {
    interface IBase {
        fun getX(): Int
    }

    class BaseImpl(private val x: Int) : IBase {
        override fun getX(): Int = x
    }

    @Test
    fun simple() {
        assertEquals(42, BaseImpl(42).getX())
    }
}