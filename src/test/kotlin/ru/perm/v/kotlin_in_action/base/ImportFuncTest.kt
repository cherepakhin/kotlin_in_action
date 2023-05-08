package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import ru.perm.v.kotlin_in_action.getDescription // Можно импортироввать функции

class ImportFuncTest {
    @Test
    internal fun simple() {
        Assertions.assertEquals("id.toString() + name + age", getDescription());
    }
}