package net.ntworld.hexagon.foundation.old_validation

interface Validatable {
    fun containsKey(key: String): Boolean

    fun <T> get(key: String): T

    fun <T> set(key: String, value: T)
}