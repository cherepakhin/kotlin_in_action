package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ClassCreateTest {
    class PersonSimple(val name: String)

    @Test
    internal fun simple() {
        val person = PersonSimple("NAME")
        Assertions.assertEquals("NAME", person.name)
    }
}