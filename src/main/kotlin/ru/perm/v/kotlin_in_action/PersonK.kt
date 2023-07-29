package ru.perm.v.kotlin_in_action

// data class. equals и hashcode на основе параметров id,name,age
data class PersonK(
    val id: Int,
    var name: String, // val неизменяемое. Нет сеттера. Присвоение только через конструктор
    var age: Int? // nullable
) {
    fun getDescription(): String {
        return "id=%s, name=%s, age=%s".format(id, name, age)
    }
}

