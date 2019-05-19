package net.ntworld.hexagon.foundation.validation

interface Validatable {
    fun containsKey(key: String): Boolean

    fun <T> get(key: String): T

    fun <T> set(key: String, value: T)
}