package ru.perm.v.kotlin_in_action

class PersonK(
    val name: String, // val неизменяемое. Нет сеттера. Присвоение только через конструктор
    var age: Int = 0
)