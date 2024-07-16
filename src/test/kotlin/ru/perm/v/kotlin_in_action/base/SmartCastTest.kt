package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class SmartCastTest {
    @Test
    fun toIntOk() {
        val str = "123"
        val i = str.toInt()
        assertEquals(123, i)
    }

    @Test
    fun toIntFalse() {
        val str = "a123"
        val error = assertThrows<NumberFormatException> { val i = str.toInt() }

        assertEquals("For input string: \"a123\"", error.message)
    }

}