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
        val person = Person("Tom")
        assertTrue(person is Person) // key word IS
        assertFalse(person is Employee)

        val empl = Employee("Tom", "Company")

        // свойство company можно проверять после &&, т.к. перед этим проверено, что empl это Employee
        assertTrue(empl is Employee && empl.company == "Company")

        assertTrue(isEmployee(empl))
        assertFalse(isEmployee(person))
        assertTrue(empl is Person) // Employee is Person!!!
    }

    fun isEmployee(p: Person): Boolean {
        return p is Employee // Test KEY WORD "IS"
    }

    @Test
    fun whenTestForPerson() {
        val person = Person("person")
        var result = ""
        when (person) {
            is Person -> result = "is Person"
            is Employee -> result = "is Employee"
            is Manager -> result = "is Manager"
        }

        assertEquals("is Person", result)
    }

    @Test
    fun whenTestForManagerIsPerson() {
        val manager = Manager("manager")
        var result = ""
        when (manager) {
            is Person -> result = "is Person"
            is Manager -> result = "is Manager"
        }

        assertEquals("is Person", result) // Manager is Person
    }

    @Test
    fun whenTestForManagerIsManager() {
        val manager = Manager("manager")
        var result = ""
        when (manager) {
            is Manager -> result = "is Manager"
            is Person -> result = "is Person"
        }

        assertEquals("is Manager", result)
    }

    fun isManager(person: Person): Boolean {
        return person is Manager
    }

    @Test
    fun isManagerTest() {
        assertTrue(isManager(Manager("manager")))
    }

    @Test
    fun isManagerForPersonTest() {
        assertFalse(isManager(Person("manager")))
    }

}