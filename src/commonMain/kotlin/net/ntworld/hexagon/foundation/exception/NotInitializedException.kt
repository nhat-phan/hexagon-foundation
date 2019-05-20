package net.ntworld.hexagon.foundation.exception

import net.ntworld.hexagon.foundation.builder.Builder
import kotlin.reflect.KProperty

class NotInitializedException(val builder: Builder, val property: KProperty<*>) : Exception()