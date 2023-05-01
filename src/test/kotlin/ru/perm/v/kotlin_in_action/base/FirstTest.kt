package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FirstTest {
    data class Person(val name: String, val age: Int)

    @Test
    internal fun create() {
        val person = Person("NAME", 100)
        assertEquals(100, person.age)
        assertEquals("NAME", person.name)
    }

}