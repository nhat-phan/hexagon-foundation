package net.ntworld.hexagon.foundation

import net.ntworld.hexagon.foundation.internal.*

interface ArgumentBuilderData : Map<String, Any> {
    fun <T> getValue(key: String): T

    fun <T> getValue(key: String, defaultValue: T): T

    fun ifNot(key: String, value: Boolean, lambda: (value: Any?) -> Unit): Boolean


    fun isString(key: String): Boolean

    fun isNotString(key: String): Boolean = !this.isString(key)

    fun isNotString(key: String, lambda: (value: Any?) -> Unit): Boolean = this.ifNot(key, this.isString(key), lambda)


    fun isStringAndNotBlank(key: String): Boolean

    fun isNotStringOrBlank(key: String): Boolean = !this.isStringAndNotBlank(key)

    fun isNotStringOrBlank(key: String, lambda: (value: Any?) -> Unit): Boolean =
        this.ifNot(key, this.isStringAndNotBlank(key), lambda)

    fun isNotStringOrEmpty(key: String): Boolean = !this.isStringAndNotBlank(key)

    fun isNotStringOrEmpty(key: String, lambda: (value: Any?) -> Unit): Boolean =
        this.ifNot(key, this.isStringAndNotBlank(key), lambda)


    fun isInteger(key: String): Boolean

    fun isNotInteger(key: String): Boolean = !this.isInteger(key)

    fun isNotInteger(key: String, lambda: (value: Any?) -> Unit): Boolean = this.ifNot(key, this.isInteger(key), lambda)


    fun isPositiveInteger(key: String): Boolean

    fun isNotPositiveInteger(key: String): Boolean = !this.isPositiveInteger(key)

    fun isNotPositiveInteger(key: String, lambda: (value: Any?) -> Unit): Boolean =
        this.ifNot(key, this.isPositiveInteger(key), lambda)

}
