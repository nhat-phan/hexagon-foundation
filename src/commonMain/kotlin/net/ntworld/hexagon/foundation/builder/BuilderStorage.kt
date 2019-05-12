package net.ntworld.hexagon.foundation.builder

interface BuilderStorage {
    fun containsKey(key: String): Boolean

    fun <T> get(key: String): T

    fun <T> set(key: String, value: T)
}