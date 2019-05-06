package net.ntworld.hexagon.foundation.internal

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class ArgumentBuilderDataImplTest {
    private val data = ArgumentBuilderDataImpl(
        mapOf(
            "int-zero" to 0,
            "int-positive" to 100,
            "int-negative" to -100,
            "boolean" to true,
            "boolean-true" to true,
            "boolean-false" to false,
            "string-empty" to "",
            "string" to "hello"
        )
    )

    @Test
    fun isString() {
        assertFalse(data.isString("int-zero"))
        assertFalse(data.isString("boolean"))
        assertTrue(data.isString("string-empty"))
        assertTrue(data.isString("string"))
    }

    @Test
    fun isNotString() {
        assertTrue(data.isNotString("int-zero"))
        assertTrue(data.isNotString("boolean"))
        assertTrue(data.isNotString("not-found"))
        assertFalse(data.isNotString("string-empty"))
        assertFalse(data.isNotString("string"))

        var called = 0
        assertTrue(
            data.isNotString("int-zero") {
                called++
                assertEquals(0, it)
            }
        )

        assertTrue(
            data.isNotString("boolean") {
                called++
                assertEquals(true, it)
            }
        )

        assertTrue(
            data.isNotString("not-found") {
                called++
                assertEquals(null, it)
            }
        )

        assertFalse(
            data.isNotString("string-empty") {
                called++
            }
        )
        assertEquals(3, called)
    }

    @Test
    fun isNotStringOrBlank() {
        assertTrue(data.isNotStringOrBlank("int-zero"))
        assertTrue(data.isNotStringOrBlank("boolean"))
        assertTrue(data.isNotStringOrBlank("string-empty"))
        assertTrue(data.isNotStringOrBlank("not-found"))
        assertFalse(data.isNotStringOrBlank("string"))

        var called = 0
        assertTrue(
            data.isNotStringOrBlank("int-zero") {
                called++
                assertEquals(0, it)
            }
        )

        assertTrue(
            data.isNotStringOrBlank("boolean") {
                called++
                assertEquals(true, it)
            }
        )

        assertTrue(
            data.isNotStringOrBlank("string-empty") {
                called++
                assertEquals("", it)
            }
        )

        assertTrue(
            data.isNotStringOrBlank("not-found") {
                called++
                assertEquals(null, it)
            }
        )

        assertFalse(
            data.isNotStringOrBlank("string") {
                called++
            }
        )
        assertEquals(4, called)
    }

    @Test
    fun isNotStringOrEmpty() {
        assertTrue(data.isNotStringOrEmpty("int-zero"))
        assertTrue(data.isNotStringOrEmpty("boolean"))
        assertTrue(data.isNotStringOrEmpty("string-empty"))
        assertTrue(data.isNotStringOrEmpty("not-found"))
        assertFalse(data.isNotStringOrEmpty("string"))

        var called = 0
        assertTrue(
            data.isNotStringOrEmpty("int-zero") {
                called++
                assertEquals(0, it)
            }
        )

        assertTrue(
            data.isNotStringOrEmpty("boolean") {
                called++
                assertEquals(true, it)
            }
        )

        assertTrue(
            data.isNotStringOrEmpty("string-empty") {
                called++
                assertEquals("", it)
            }
        )

        assertTrue(
            data.isNotStringOrEmpty("not-found") {
                called++
                assertEquals(null, it)
            }
        )

        assertFalse(
            data.isNotStringOrEmpty("string") {
                called++
            }
        )
        assertEquals(4, called)
    }

    @Test
    fun isInteger() {
        assertTrue(data.isInteger("int-zero"))
        assertFalse(data.isInteger("boolean"))
        assertFalse(data.isInteger("string-empty"))
        assertFalse(data.isInteger("string"))
    }

    @Test
    fun isNotInteger() {
        assertFalse(data.isNotInteger("int-zero"))
        assertFalse(data.isNotInteger("int-positive"))
        assertFalse(data.isNotInteger("int-negative"))
        assertTrue(data.isNotInteger("boolean"))
        assertTrue(data.isNotInteger("string"))

        var called = 0
        assertTrue(
            data.isNotInteger("boolean") {
                called++
                assertEquals(true, it)
            }
        )

        assertTrue(
            data.isNotInteger("string") {
                called++
                assertEquals("hello", it)
            }
        )

        assertFalse(
            data.isNotInteger("int-zero") {
                called++
            }
        )
        assertEquals(2, called)
    }

    @Test
    fun isPositiveInteger() {
        assertTrue(data.isPositiveInteger("int-positive"))
        assertFalse(data.isPositiveInteger("int-zero"))
        assertFalse(data.isPositiveInteger("int-negative"))
        assertFalse(data.isPositiveInteger("boolean"))
        assertFalse(data.isPositiveInteger("string-empty"))
        assertFalse(data.isPositiveInteger("string"))
    }

    @Test
    fun isNotPositiveInteger() {
        assertFalse(data.isNotPositiveInteger("int-positive"))
        assertTrue(data.isNotPositiveInteger("int-zero"))
        assertTrue(data.isNotPositiveInteger("int-negative"))
        assertTrue(data.isNotPositiveInteger("boolean"))
        assertTrue(data.isNotPositiveInteger("string"))

        var called = 0
        assertTrue(
            data.isNotPositiveInteger("boolean") {
                called++
                assertEquals(true, it)
            }
        )

        assertTrue(
            data.isNotPositiveInteger("int-negative") {
                called++
                assertEquals(-100, it)
            }
        )

        assertFalse(
            data.isNotPositiveInteger("int-positive") {
                called++
            }
        )
        assertEquals(2, called)
    }
}