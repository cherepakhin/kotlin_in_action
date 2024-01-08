package ru.perm.v.kotlin_in_action

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
Data class. [https://kotlinlang.ru/docs/reference/data-classes.html](https://kotlinlang.ru/docs/reference/data-classes.html).
Классы данных не могут быть абстрактными, open, sealed или inner.
Компилятор автоматически формирует следующие члены данного класса из __свойств__,
объявленных __в основном конструкторе__: equals()/hashCode(), toString() в форме "PersonK(-1, "-", 0)",
компонентные функции componentN(), которые соответствуют свойствам, в соответствии с порядком их объявления.
Основной конструктор должен иметь как минимум один параметр.
Все параметры основного конструктора должны быть отмечены, как val или var.
Классы данных не могут быть абстрактными, open, sealed или inner.
 */


class PersonKTest {
    @Test
    internal fun create() {
        val person = PersonK(id =-1,  name="-", age = 0)
        // Вызывается метод чтения getName. Kotlin сам его создает.
        assertEquals("-", person.name)
    }

    @Test
    fun getDescriptionWithNull() {
        val person = PersonK(100, "NAME", null)
        assertEquals("id=100, name=NAME, age=null", person.getDescription())
    }

    @Test
    fun getDescription() {
        val person = PersonK(100, "NAME", 10)
        assertEquals("id=100, name=NAME, age=10", person.getDescription())
    }

    @Test
    fun testToString() {
        val person = PersonK(100, "NAME", 10)
        assertEquals("PersonK(id=100, name=NAME, age=10)", person.toString())
    }

    @Test
    fun testEquals() {
        val person1 = PersonK(100, "NAME", 10)
        val person2 = PersonK(100, "NAME", 10)
        assertEquals(person1, person2)
    }
}