package sample

import kotlin.test.Test

interface ITodo {
    val name: String
}

data class Todo(override val name: String): ITodo

interface Port<in T> {
    fun with(args: T)
}

class TodoPort: Port<ITodo> {
    override fun with(args: ITodo) {
        TODO("not implemented")
    }
}

class SampleTests {
    @Test
    fun testMe() {
        val port: Port<ITodo> = TodoPort()

    }

    fun rotate() {

    }
}