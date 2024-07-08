package com.sankore

import java.util.*

enum class EntityType(private val _label: String) {
    EASY("Easy"),
    MEDIUM("Medium"),
    HARD("Hard");

    val getLabel: String
        get() = _label.lowercase(Locale.getDefault())
}

// sealed classes allows us to define a series of classes that
// can extend a base type and only them can extend that base type

object EntityFactory {
    fun create(type: EntityType) : Entity {
        val uniqueId = UUID.randomUUID().toString()
        val name = when(type) {
            EntityType.EASY -> EntityType.EASY.getLabel
            EntityType.MEDIUM -> EntityType.MEDIUM.getLabel
            EntityType.HARD -> EntityType.HARD.getLabel
        }
        return Entity(uniqueId, name)
    }

    fun createDomainEntity(type: EntityType) : DomainEntity {
        val uniqueId = UUID.randomUUID().toString()
        val name = when(type) {
            EntityType.EASY -> EntityType.EASY.getLabel
            EntityType.MEDIUM -> EntityType.MEDIUM.getLabel
            EntityType.HARD -> EntityType.HARD.getLabel
        }
        return when(type) {
            EntityType.EASY -> DomainEntity.Easy(uniqueId, name)
            EntityType.MEDIUM -> DomainEntity.Medium(uniqueId, name)
            EntityType.HARD -> DomainEntity.Hard(uniqueId, name)
        }
    }
}

// data classes are immutable, and provides an automatic impl of hashcode and to string for comparing
// these objects, and also it provides a copy method to clone an object
// a == checks if the properties are equal,
// for referential comparison === is used

sealed class DomainEntity {
    object helper { // this is a singleton
        val name = "Helper"
    }
    data class Easy(val uniqueId: String, val name: String): DomainEntity()
    data class Medium(val uniqueId: String, val name: String): DomainEntity()
    data class Hard(val uniqueId: String, val name: String): DomainEntity()
}

// extension method
fun DomainEntity.Medium.shoutOut() {
    println("Medium challenge: $uniqueId")
}
// extension properties
val DomainEntity.Medium.info: String
    get() = "Something Fancy"


class Entity(
    private val id :String,
    private val name :String
) {
    override fun toString(): String {
        return "Entity(id='$id', name='$name')"
    }
}

/*
* a companion object is an object scoped to an instance of another class
*
* Object declaration is a convenient way of creating thread safe singletons within KT
* */

fun main() {
    val entity = EntityFactory.create(EntityType.EASY)
    println(entity)

    val entityOne = EntityFactory.createDomainEntity(EntityType.EASY)
    val entityTwo = EntityFactory.createDomainEntity(EntityType.HARD)

    if (entityOne == entityTwo) {
        println("They are equal")
    } else {
        println("They are not equal")
    }
    // but for referential equality use === to check what reference type the object is
}