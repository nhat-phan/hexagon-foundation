package sample

import kotlin.test.Test

interface ITodo {
    val name: String
}

interface ITodoBuilder {
    fun setName(value: String)
}

interface ITodoValidator<T> {
    fun validate(builder: T)
}

interface ITodoFactory<T, A> {
    fun make(builder: T): A
}

class Port {
    fun makeArgument() {

    }
}

class SampleTests {
    @Test
    fun testMe() {


    }

    fun rotate() {

    }
}