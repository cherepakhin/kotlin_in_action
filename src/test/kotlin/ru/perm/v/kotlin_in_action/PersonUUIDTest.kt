package ru.perm.v.kotlin_in_action

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PersonUUIDTest {

    @Test
    fun generateNew() {
        val person = PersonUUID("NAME")
        assertEquals("NAME", person.name)
        println(person.id) // id will be assigned in constructor
        assertNotNull(person.id)
    }

    @Test
    fun compareGenerated_2_Person() {
        val person1 = PersonUUID("NAME")
        val person2 = PersonUUID("NAME")
        println(person1.id)
        println(person2.id)
        assertNotEquals(person1.id, person2.id)
    }
}