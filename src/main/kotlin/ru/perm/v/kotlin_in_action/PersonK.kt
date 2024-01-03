package ru.perm.v.kotlin_in_action

// data class. equals и hashcode на основе параметров id,name,age
data class PersonK(
    val id: Int, // задается только в конструкторе. VAL после присвоения менять нельзя,
    // неизменяемое. Нет сеттера. Присвоение только через конструктор
    var name: String, // VAR можно менять после присвоения
    var age: Int? // nullable
) {
    var comment: String = "-"
    fun getDescription(): String {
        return "id=%s, name=%s, age=%s".format(id, name, age)
    }
}

