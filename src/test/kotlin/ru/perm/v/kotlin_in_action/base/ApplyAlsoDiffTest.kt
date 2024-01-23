package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Делегирование.
 *
 * apply и also - выполнение сопутствующей задачи
 * Разница между apply и also заключается в том, что apply применяется к объекту, как бы внутри объекта,
 * а also обращается через "it"
 */
class ApplyAlsoDiffTest {
    @Test
    fun applyTest() {
        data class Person(var name: String, var age: Int, var city: String)
        val person = Person("Tom", 10, "Moscow").apply { age = 20 } // нет it
        assertEquals(Person("Tom", 20, "Moscow"), person)
    }

    @Test
    fun alsoTest() {
        data class Person(var name: String, var age: Int, var city: String)
        val person = Person("Tom", 10, "Moscow").also { it.age = 20 } // it!!!
        assertEquals(Person("Tom", 20, "Moscow"), person)
    }
}