package com.sankore

interface PersonAdapter {
    fun callPerson(name:String):String
    fun defaultHandler() {
        println("Hallo")
    }
}

class BasicPersonAdapter : PersonAdapter {
    override fun callPerson(name: String): String {
        return "Hi $name"
    }
}

fun main() {
    val person = BasicPersonAdapter()
    println(person.callPerson("John"))
    println(person.callPerson("test"))
    person.defaultHandler()
    /*
    * You need the open keyword to extend a class in KT
    * */
}