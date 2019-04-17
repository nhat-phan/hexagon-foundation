package net.ntworld.hexagon.foundation

internal data class ArgumentImpl(
    override val uniqueId: String,
    override val context: ArgumentContext
) : Argument