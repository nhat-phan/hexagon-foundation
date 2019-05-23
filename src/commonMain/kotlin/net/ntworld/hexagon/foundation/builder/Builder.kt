package net.ntworld.hexagon.foundation.builder

import net.ntworld.hexagon.foundation.validation.Validatable

interface Builder : Validatable {
    val builderStorage: BuilderStorage

    override fun containsKey(key: String): Boolean = builderStorage.containsKey(key)
}