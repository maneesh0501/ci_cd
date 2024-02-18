package com.example.test

import android.util.Log
import kotlin.random.Random

fun main() {
    val firstName: String? = "null"
    var middleName: String? = null
    var lastName: String? = null

    middleName = " M "
    lastName = "Sharma"

    firstName?.run {
        val fullName = this + middleName + lastName
        println(fullName)
    }

    var list = mutableListOf<Int>(1,2,3)

    with(list) {
        add(4)
        println(this)
        println(size)
    }

    list.also {
        it.add(5)
        it.removeAt(2)
    }
    println("list = $list")

}

class Basics() : Abs(), Inf {

    val adam = Person("Adam").apply {
        this.age = 20
        city = "Raipur"
        //Chain function
        val number = mutableListOf("one", "two", "three", "four", "five")
        val result = number.map { it.length }.filter { it > 3 }.let { println(it) }

        with(number) {
            println(this)
            println(size)
        }
        var service = "https://example.com"
        service.run {
            //port check
            //query request
        }
    }

    fun getRamdon(): Int {
        return Random.nextInt(100).also {
            Log.e("Maggi", "getRamdon: $it" )
        }
    }


    //Chain function
    val number = mutableListOf("one", "two", "three", "four", "five")
    val result = number.map { it.length }.filter { it > 3 }.let { println(it) }


    //Null safety
    val str: String? = "Hello"
    val length = str?.let {
        println(it)
        it.length
    }

    override fun first() {
        TODO("Not yet implemented")
    }

}

class Person(val name: String) {
    var age: Int = 0
    var city: String? = null
}

abstract class Abs {
    abstract fun first()
}

interface Inf