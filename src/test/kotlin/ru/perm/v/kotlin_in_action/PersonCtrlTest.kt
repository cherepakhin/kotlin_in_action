package ru.perm.v.kotlin_in_action

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class PersonCtrlTest {

    @Test
    fun getNotFoundPerson() {
        val personCtrl = PersonCtrl()
        assertEquals(PersonK(-1, "NOT FOUND PERSON", 0), personCtrl.getById(200))
    }

    @Test
    fun getPersons() {
        val persons = PersonCtrl().index()

        assertEquals(3, persons.size)
        assertEquals(PersonK(1, "name1", 10), persons.get(0))
        assertEquals(PersonK(2, "name2", 20), persons.get(1))
        assertEquals(PersonK(100, "name100", 100), persons.get(2))

        assertEquals(listOf(
            PersonK(1, "name1", 10),
            PersonK(2, "name2", 20),
            PersonK(100, "name100", 100), // для проверки сортировки
        ), persons)
    }

    @Test
    fun index() {
        val personCtrl = PersonCtrl()
        assertEquals(PersonK(2, "name2", 20), personCtrl.getById(2))
    }
}