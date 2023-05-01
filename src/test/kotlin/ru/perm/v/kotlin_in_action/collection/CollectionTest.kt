package ru.perm.v.kotlin_in_action.collection

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CollectionTest {
    data class Person(val name: String, val age: Int)
    val persons = listOf(Person("NAME1", 1), Person("NAME2", 2))

    @Test
    internal fun collectionSizeTest() {
        Assertions.assertEquals(2, persons.size)
    }


}