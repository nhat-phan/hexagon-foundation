package net.ntworld.hexagon.foundation.internal

import net.ntworld.hexagon.foundation.Argument
import net.ntworld.hexagon.foundation.ArgumentContext

internal data class ArgumentImpl(
    override val uniqueId: String,
    override val context: ArgumentContext
) : Argument

