package net.ntworld.hexagon.foundation.builder

import net.ntworld.kotlin.validator.Validatable

interface Builder : Validatable {
    val builderStorage: BuilderStorage

    override fun containsKey(key: String): Boolean = builderStorage.containsKey(key)
}