package net.ntworld.hexagon.foundation.abac.internal

import net.ntworld.hexagon.foundation.abac.Context

internal data class ContextImpl(
    override val environmentType: String,
    override val environmentId: String,
    override val datetime: String,
    override val ipAddress: String,
    override val location: String?
) : Context

