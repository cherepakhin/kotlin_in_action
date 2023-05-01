package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class FirstTest {
    // "?" м.б. null
    data class Person(val name: String, val age: Int?)

    @Test
    internal fun create() {
        val person = Person("NAME", 100)
        assertEquals(100, person.age)
        assertEquals("NAME", person.name)
    }
    @Test
    internal fun createWithNull() {
        // val age: Int? м.б. null
        val person = Person("NAME", null)
        assertNull(person.age)
        assertEquals("NAME", person.name)
    }

}