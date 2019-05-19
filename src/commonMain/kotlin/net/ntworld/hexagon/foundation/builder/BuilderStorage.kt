package net.ntworld.hexagon.foundation.builder

import net.ntworld.hexagon.foundation.validation.Validatable

interface BuilderStorage : Validatable {
    fun clear()
}