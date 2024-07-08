package com.sankore

class Person(val _firstName: String, val _secondName: String) {
    /*val firstName: String = _firstName
    val secondName: String = _secondName*/

    /*init {
        this.firstName = _firstName
        this.secondName = _secondName
    }*/
    override fun toString(): String {
        return "Person(_firstName='$_firstName', _secondName='$_secondName')"
    }
}