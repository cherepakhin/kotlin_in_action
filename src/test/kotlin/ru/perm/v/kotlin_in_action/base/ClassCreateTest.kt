package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ClassCreateTest {

    @Test
    internal fun immutableTest() {
        class PersonSimpleImmutable(val name: String) // VAL!!! после присвоения, name менять нельзя

        val person = PersonSimpleImmutable("NAME")
        // person.name ="" // после присвоения, name менять нельзя
        assertEquals("NAME", person.name)

        class PersonSimpleImmutableLast() {
            var name = "" // vaR!!! после присвоения, name менять МОЖНО
        }

        val person1 = PersonSimpleImmutableLast()
        person1.name = "NAME1"
        assertEquals("NAME1", person1.name)
    }

    @Test
    internal fun immutableWithFieldTest() {
        class PersonSimpleImmutable() {
            val name: String
                get() {
                    // Какое-то-то сложное вычисление
                    return "NAME " + "IMMUTABLE"
                }
//                set(s:String) { // VAL!!! name менять нельзя
//                    name =s
//                }
        }
        assertEquals("NAME IMMUTABLE", PersonSimpleImmutable().name)
    }

    @Test
    internal fun mutableTest() {
        class PersonSimpleMutable(var name: String)

        val p = PersonSimpleMutable("FIRST_VAL")
        p.name = "SECOND_VAL" // VAR - после присвоения, менять можно
        assertEquals("SECOND_VAL", p.name)
    }

    @Test
    internal fun mutableNotSimpleLateTest() {
        class PersonSimpleMutableLate() {
            lateinit var name: String // Если lateinit убрать, то IDEA покажет ошибку и нужно присвоить значение
            // НЕПРИМЕНИМО для vaL
        }

        val p = PersonSimpleMutableLate()
        // lateinit - если не присвоено, то ошибка:
        //      Assertions.assertEquals("VALUE", p.name)
        // Ошибка:
        // lateinit property name has not been initialized

        // idea НЕ ПОДСВЕТИТ ошибку, т.к. lateinit, но при выполнении падает с ошибкой:
        // Assertions.assertEquals("VALUE", p.name)

        // Ошибка при выполнении:
        // lateinit property name has not been initialized
        // kotlin.UninitializedPropertyAccessException: lateinit property name has not been initialized

        p.name = "---"
        assertEquals("---", p.name)
        p.name = "VALUE"
        assertEquals("VALUE", p.name)
    }

}