package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import ru.perm.v.kotlin_in_action.getCalcFunc // Можно импортироввать функции

class ImportFuncTest {
    @Test
    internal fun simple() {
        Assertions.assertEquals("id.toString() + name + age, CONST", getCalcFunc());
    }
}