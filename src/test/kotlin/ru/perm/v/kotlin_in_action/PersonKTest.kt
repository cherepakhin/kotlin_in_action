package ru.perm.v.kotlin_in_action

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PersonKTest {
    @Test
    internal fun create() {
        val person = PersonK(-1, "-", 0)
        // Вызывается метод чтения getName. Kotlin сам его создает.
        assertEquals("-", person.name)
    }

    @Test
    fun getDescription() {
        val person = PersonK(100, "NAME", null)
        assertEquals("100NAMEnull", person.getDescription())
    }
}