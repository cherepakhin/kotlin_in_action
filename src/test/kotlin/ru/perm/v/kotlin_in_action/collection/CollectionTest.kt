package ru.perm.v.kotlin_in_action.collection

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CollectionTest {
    data class Person(val id:Int,val name: String, val age: Int)
    val persons = listOf(Person(1,"NAME1", 10), Person(2, "NAME2", 20))

    @Test
    internal fun collectionSizeTest() {
        Assertions.assertEquals(2, persons.size)
    }

    @Test
    internal fun maxByTest() {
        Assertions.assertEquals(20, persons.maxBy { it.age?:0 }.age)
    }

}