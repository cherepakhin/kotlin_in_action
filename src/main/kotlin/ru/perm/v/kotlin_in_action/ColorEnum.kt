package ru.perm.v.kotlin_in_action

enum class ColorEnum {
    RED, YELLOW, GREEN;

    open fun getAll(): String = RED.name + YELLOW.name + GREEN.name
}