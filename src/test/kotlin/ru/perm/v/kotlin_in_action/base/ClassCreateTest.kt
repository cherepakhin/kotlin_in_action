package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ClassCreateTest {

    @Test
    internal fun immutableTest() {
        class PersonSimpleImmutable(val name: String) // VAL!!! после присвоения, name менять нельзя

        val person = PersonSimpleImmutable("NAME")
        // person.name ="" // после присвоения, name менять нельзя
        Assertions.assertEquals("NAME", person.name)

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
        Assertions.assertEquals("SECOND_VAL", p.name)
    }

    @Test
    internal fun mutableNotSimpleLateTest() {
        class PersonSimpleMutableLate() {
            lateinit var name: String
        }

        val p = PersonSimpleMutableLate()
        // Assertions.assertEquals("VALUE", p.name) // т.к. lateinit, то ошибка
        // lateinit property name has not been initialized
        // kotlin.UninitializedPropertyAccessException: lateinit property name has not been initialized

        p.name = "---" // VAL, но LATEINIT - инициализация отложена
        Assertions.assertEquals("---", p.name)
        p.name = "VALUE" // Но можно присваивать
        Assertions.assertEquals("VALUE", p.name)
    }

}