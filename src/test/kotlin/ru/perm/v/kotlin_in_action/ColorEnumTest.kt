package ru.perm.v.kotlin_in_action

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.util.*

internal class ColorEnumTest {

    @Test
    internal fun funYellow() {
        val yellow = ColorEnum.YELLOW
        assertEquals(ColorEnum.YELLOW, yellow)
    }

    @Test
    fun getAll() {
        assertEquals(listOf(ColorEnum.RED, ColorEnum.YELLOW, ColorEnum.GREEN), ColorEnum.values().asList())
    }
}