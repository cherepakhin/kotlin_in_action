package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class StringTest {
    @Test
    internal fun valvarsubs() {
        val s1 = "s1"
        var s1a = s1 + "a"
        Assertions.assertEquals("s1a", s1a)
    }

}