package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class StringTest {
    @Test
    internal fun simple() {
        val s1 = "s1"
        var s1a = s1 + "a"
        Assertions.assertEquals("s1a", s1a)
    }

    @Test
    internal fun strTemplate() {
        val s = "STR"
        val templ = "s=${s}"
        Assertions.assertEquals("s=STR", templ)
    }
}