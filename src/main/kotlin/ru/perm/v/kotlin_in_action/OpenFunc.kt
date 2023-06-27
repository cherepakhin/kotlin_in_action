package ru.perm.v.kotlin_in_action

val aConst = ", CONST"

// В Kotlin можно определить только функцию, БЕЗ СОЗДАНИЯ КЛАССА
fun getCalcFunc(): String {
    return "id.toString() + name + age" + aConst
}
