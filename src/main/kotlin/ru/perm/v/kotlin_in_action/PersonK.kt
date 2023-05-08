package ru.perm.v.kotlin_in_action

open class PersonK(
    val id: Int,
    val name: String, // val неизменяемое. Нет сеттера. Присвоение только через конструктор
    var age: Int? // nullable
) {
    fun getDescription(): String {
        return id.toString() + name + age
    }
}

