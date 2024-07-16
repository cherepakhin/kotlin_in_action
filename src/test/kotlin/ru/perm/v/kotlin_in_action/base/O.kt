package ru.perm.v.kotlin_in_action.base

class O {
    private var prop: String = "";

    constructor()
    constructor(prop: String) {
        this.prop = prop
    }


    fun setProp(s: String): Unit {
        prop = s
    }

    fun getProp(): String {
        return prop;
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is O) return false

        if (prop != other.prop) return false

        return true
    }

    override fun hashCode(): Int {
        return prop.hashCode()
    }
}