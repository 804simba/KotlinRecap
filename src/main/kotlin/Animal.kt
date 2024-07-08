package com.sankore

open class Animal(
    private val _name :String,
    private val _numberOfLegs :Int
) : Running {
    var name: String? = null
    var numberOfLegs: Int = 0

    init {
        name = _name
        numberOfLegs = _numberOfLegs
    }

    override fun canRun(): Boolean {
        println("Animal canRun")
        return true
    }
}

interface Running {
    fun canRun(): Boolean
}

fun main() {
    val animal: Animal = Animal("Chuck", 4)
    println(animal.canRun())
}
interface Laughing {
    fun canLaugh()
}