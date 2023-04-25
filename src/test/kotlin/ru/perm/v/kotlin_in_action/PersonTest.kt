package ru.perm.v.kotlin_in_action

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PersonTest {
    @Test
    internal fun create() {
        val person = Person("-",1)
        // Вызывается метод чтения getName. Kotlin сам его создает.
        assertEquals("-", person.name)
    }
}