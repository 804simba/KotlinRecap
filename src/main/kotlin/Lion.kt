package com.sankore

class Lion(
    private val _name: String,
    private val _numberOfLegs: Int
) : Animal(_name, _numberOfLegs), Laughing {

    override fun canLaugh() {
        println("Lion can Laugh")
    }
}

fun main() {
    val lion : Lion = Lion("Lion", 5)
    lion.canLaugh()
    lion.canRun()

    // anonymous class in KT
    val animal = object : Animal("Rabbit", 7) {
        override fun canRun(): Boolean {
            println("Can run")
            return true
        }

        fun shoutOut() {
            println("Shout out")
        }
    }

    animal.canRun()
    animal.shoutOut()
}