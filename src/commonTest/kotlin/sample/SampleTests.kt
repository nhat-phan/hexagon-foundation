package sample

import kotlin.test.Test

class SampleTests {
    @Test
    fun testMe() {
        val map = mapOf(
            "a" to 1,
            "b" to "string",
            "c" to 'A'
        )
        println(map.get("a") is Int)
        println(map.get("b") is String)
        println(map.get("c") is String)
        println(map.get("d") is String)
    }

    fun rotate() {

    }
}