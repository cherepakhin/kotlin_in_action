package ru.perm.v.kotlin_in_action.base

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class AssignTest {
    // класса нет. Определяется из контекста, присвоением ( = "" )
    var a = ""
        set(value) {
            field = value // тут "field" ключевое слово. Дает доступ к свойству
        }

    @Test
    internal fun assign() {
        a = "-"
//        a = 1 //RED ERROR. Класс д.б. String
        Assertions.assertEquals("-", a)
    }
}