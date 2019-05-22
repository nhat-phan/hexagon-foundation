package net.ntworld.hexagon.foundation.builder

import net.ntworld.hexagon.foundation.old_validation.Validatable

interface BuilderStorage : Validatable {
    fun clear()
}