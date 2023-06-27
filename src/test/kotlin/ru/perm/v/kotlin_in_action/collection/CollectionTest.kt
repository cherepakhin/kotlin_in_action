package ru.perm.v.kotlin_in_action.collection

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CollectionTest {
    data class Person(val id: Int, val name: String, val age: Int?)

    val persons = listOf(
        Person(1, "NAME1", 10),
        Person(2, "NAME2", 20),
        Person(-1, "NAME-1", null)
    )

    @Test
    internal fun collectionSizeTest() {
        // internal видно внутри модуля. Модуль - это набор скомпилированных вместе Kotlin файлов, например:
        // модуль IntelliJ IDEA; Maven проект;
        Assertions.assertEquals(3, persons.size)
    }

    @Test
    // elvis. Если age=null, то -100
    internal fun minByAgeTestWithElvis() {
        Assertions.assertNull(persons.minBy { it.age ?: -100 }.age)
    }

    @Test
    internal fun maxByIdTest() {
        Assertions.assertEquals("NAME2", persons.maxBy { it.id }.name)
    }
}