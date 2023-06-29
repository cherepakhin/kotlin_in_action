package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import ru.perm.v.kotlin_in_action.PersonK

/**
 * Передача параметров. Всегда передает параметры по значению.
 */
class TransferParamTest {

    @Test
    fun unmodifiedSrcListForString() {
        val srcList = listOf("a1", "a2")
        val changedList = changeAndReturnNewList(srcList)
        assertEquals("a1", srcList.get(0))
        assertEquals("a2", srcList.get(1))
        assertEquals("NEW_VAL", changedList.get(0))
        assertEquals("a2", changedList.get(1))
        // Проверяю, что changedList изменен
        // all это функция в List. Returns true if all elements match the given predicate.
        assertFalse(changedList.all { //проверка ASSERTFALSE!!! srcList содержит не все элементы changedList
            srcList.contains(it) // Перебор с итератором it. "it" текущий элемент итератора changedList.all
        })
        // проверяю, что srcList остался таким же
        assertTrue(srcList.all {
            srcList.contains(it)
        })
        // в исходном списке srcList значение не изменилось. Для объектов не работает. см.ниже unmodifiedSrcListPerson()
        assertTrue(srcList.get(0).equals("a1"))
        // в измененном списке другое значение
        assertTrue(changedList.get(0).equals("NEW_VAL"))
    }

    private fun changeAndReturnNewList(listA: List<String>): List<String> {
        val arr = ArrayList<String>(listA);
        // Значения копируются в новый список. ПОТОМУ ЧТО STRING.
        // Для обычных объектов работает по другому - не копируются. см ниже
        arr[0] = "NEW_VAL"
        return arr
    }

    // Те же самые тесты проверки списка с объектами
    @Test
    fun unmodifiedSrcForListPerson() {
        val srcList = listOf<PersonK>(
            PersonK(1, "NAME1", 1),
            PersonK(2, "NAME2", 2)
        )
        val changedList = changeAndReturn_NEW_ListPerson(srcList)
        // В srcList элемент тоже ИЗМЕНИЛСЯ,
        // несмотря на то, что был создан новый ArrayList в функции changeAndReturn_NEW_ListPerson
        assertEquals(srcList.get(0), changedList.get(0))
        assertTrue(srcList.get(0).equals(PersonK(1, "CHANGED_NAME", 1)))
        assertTrue(changedList.get(0).equals(PersonK(1, "CHANGED_NAME", 1)))
    }

    private fun changeAndReturn_NEW_ListPerson(srcList: List<PersonK>): List<PersonK> {
        // значения те же самые, не копируются, просто создается новая ссылка на тот же list
        val ret = ArrayList(srcList)
        ret[0].name = "CHANGED_NAME"
        return ret
    }
}