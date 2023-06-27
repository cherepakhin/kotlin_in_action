package ru.perm.v.kotlin_in_action

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class OpenFuncTest {

    @Test
    fun runImportFunctionTest() {
        // Вызов функции, не метода класса, а именно ФУНКЦИИ. Без создания класса.
        // Что-то типа Singleton. Короче, сломали нахуй всю строгость и чистоту. Твори че хошь.
        assertEquals("id.toString() + name + age, CONST", getCalcFunc())
    }
}