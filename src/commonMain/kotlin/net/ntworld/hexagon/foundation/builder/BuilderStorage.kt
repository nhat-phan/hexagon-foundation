package net.ntworld.hexagon.foundation.builder

import net.ntworld.kotlin.validator.Validatable

interface BuilderStorage : Validatable {
    fun clear()

    fun <T> get(key: String): T

    fun <T> set(key: String, value: T)

    fun remove(key: String)
}