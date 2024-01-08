package ru.perm.v.kotlin_in_action

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class PersonKTest {
    @Test
    internal fun create() {
        val person = PersonK(-1, "-", 0)
        // Вызывается метод чтения getName. Kotlin сам его создает.
        assertEquals("-", person.name)
    }

    @Test
    fun getDescriptionWithNull() {
        val person = PersonK(100, "NAME", null)
        assertEquals("id=100, name=NAME, age=null", person.getDescription())
    }

    @Test
    fun getDescription() {
        val person = PersonK(100, "NAME", 10)
        assertEquals("id=100, name=NAME, age=10", person.getDescription())
    }

    @Test
    fun testToString() {
        val person = PersonK(100, "NAME", 10)
        assertEquals("PersonK(id=100, name=NAME, age=10)", person.toString())
    }
}