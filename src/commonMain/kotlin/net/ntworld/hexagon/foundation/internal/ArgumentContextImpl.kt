package net.ntworld.hexagon.foundation.internal

import net.ntworld.hexagon.foundation.ArgumentContext

internal data class ArgumentContextImpl(
    override val environmentType: String,
    override val environmentId: String,
    override val datetime: String
) : ArgumentContext

