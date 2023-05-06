package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class FirstTest {

    @Test
    internal fun create() {
        // определение класса прямо внутри метода. Внутренний класс
        data class Person(val name: String, val age: Int)

        val person = Person("NAME", 100)
        assertEquals(100, person.age)
        assertEquals("NAME", person.name)
    }

    @Test
    internal fun createWithNull() {
        // "?" м.б. null
        // определение класса прямо внутри метода. Внутренний класс
        data class Person(val name: String, val age: Int?)
        // val age: Int? м.б. null. В конструкторе указано, что age нужно определить и можно null
        val person = Person("NAME", null)
        assertNull(person.age)
        assertEquals("NAME", person.name)
    }

    @Test
    internal fun createWithDefaultIfNull() {
        // определение класса прямо внутри метода. Внутренний класс
        // age:Int? т.е. м.б. null
        data class Person(val name: String, val age: Int? = 10)
        // присваиваю null. Можно присвоить, т.к. Int?
        val person = Person("NAME", null)
        assertNull(person.age)

        // А вот если не указано, то ПРИСВОИТЬ 10
        val person10 = Person("NAME")
        assertEquals(10, person10.age)

        val person1 = Person("NAME", 100)
        assertEquals(100, person1.age)
    }
}