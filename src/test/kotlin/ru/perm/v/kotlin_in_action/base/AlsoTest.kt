package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AlsoTest {
    @Test
    fun simple() {
        data class Person(var name: String, var age: Int, var city: String) {
            fun changeCity(newCity: String) { city = newCity }
            fun incrementAge() { age++ }
        }

        val alsoPerson= Person("Tom", 10, "Moscow")
            .also { it.changeCity("SPb") }
            .also { it.incrementAge() }

        assertEquals(Person("Tom", 11, "SPb"), alsoPerson)
    }
}