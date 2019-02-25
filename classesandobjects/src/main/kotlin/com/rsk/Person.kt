package com.rsk

import java.lang.Exception

interface Signatory {
    fun sign()
}

open class Person(private val name: String, var age: Int, var isMarried: Boolean = false) : Signatory {

    var partnerName: String = ""

    override fun sign() = println("$name aged $age can sign documents (and their marital status is $isMarried)")

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val p = Person("Alice", 21, true)
            p.sign()
            p.age = 54
            p.sign()

            p.partnerName = "Kevin"

            println("Partner name is ${p.partnerName}")

            p.partnerName = "Bob"

            println("Partner name is ${p.partnerName}")
        }
    }
}

class Student(name: String, age: Int) : Person(name, age)

data class User(val name: String, val id: Int)

fun main() {
    val p = Person("Alice", 21, true)
    p.sign()
    p.age = 54
    p.sign()

    val kevin = User("Kevin", 1)

    println(kevin)

    val (name, id) = kevin

    val otherUser = kevin.copy(id = 2)

    println("User is $name and their id is $id")
    println(otherUser)
}