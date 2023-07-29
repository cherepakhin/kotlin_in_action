package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.perm.v.kotlin_in_action.PersonK

class DataClassTest {

    @Test
    internal fun compateWithVarNotInConstructor() {
        val mutableMap = mutableMapOf<Int, PersonK>()

        val person20 = PersonK(20, "name20", 21)
        val person20_1 = PersonK(20, "name20", 21)

        mutableMap.put(201, person20_1)
        // разные объекты, но data classы с одинаковыми значениями
        // у DataClass equals по значениям полей
        Assertions.assertEquals(person20, person20_1)

        // comment не участвует в equals/hashcode, т.к. в data class не в скобках определения data класса
        // само поле comment доступно как обычное свойство
        person20_1.comment = "Comment20"
        Assertions.assertEquals(person20, person20_1)
    }
}