package com.sankore

const val name: String = "Richard"

fun greetNames(greeting :String, vararg names: String) {
    names.forEach {name -> println("$greeting $name") }
}

fun sayHello(username:String, age:Int) {
    println("Hello $username, you are $age years old")
}

fun main() {
    val names = arrayOf("TIMOTHY", "SIMBA", "PABLO")
    println(names[1])

    listOf(names).stream().forEach { name -> println(name) }
    names.forEach { println(it) }

    val map = mapOf(1 to "one", 2 to "two", 3 to "three")
    greetNames("Hello", "HANNAH", "ANGIE", "BLE")
    greetNames("Hello", *names)
    sayHello(username = "Simba", age = 90)

    val person = Person("Simba", "Simba")
    println(person.toString())
}

