package net.ntworld.hexagon.foundation

internal data class ArgumentContextImpl(
    override val environmentType: String,
    override val environmentId: String,
    override val datetime: String
) : ArgumentContext