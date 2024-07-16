package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

/**
 * Test smartcast
 * https://metanit.com/kotlin/tutorial/5.3.php
 */
class SmartCastTest {
    @Test
    fun fromStringToIntOk() {
        val str = "123"
        val i = str.toInt() //SMARTCAST?
        assertEquals(123, i)
    }

    @Test
    fun fromStringToIntFalse() {
        val str = "a123"
        val error = assertThrows<NumberFormatException> { val i = str.toInt() }

        assertEquals("For input string: \"a123\"", error.message)
    }

    @Test
    fun fromStringToIntWithTry() {
        val str = "a123"
        var excpt = Exception()
        try {
            str.toInt()
        } catch (e: Exception) {
            excpt = e
        }

        assertEquals("For input string: \"a123\"", excpt.message)
    }

    @Test
    fun testKeywordIS() {
        assertTrue(123 is Int)
    }

    @Test
    fun testKeywordISforObject() {
        open class Person(name: String)
        open class Employee(name: String, val company: String) : Person(name)

        val person = Person("Tom")
        assertTrue(person is Person) // key word IS
        assertFalse(person is Employee)

        val empl = Employee("Tom","Company")
        assertTrue(empl is Employee)
        assertTrue(empl is Person) // Employee IS!!! Person
    }

}