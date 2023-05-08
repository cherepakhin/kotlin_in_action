package ru.perm.v.kotlin_in_action

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ShortClassTest {
    @Test
    internal fun simple() {
        val shortClass = ShortClass("NAME")
        assertEquals("NAME", shortClass.name)
        assertEquals(-1, shortClass.age)
    }
}