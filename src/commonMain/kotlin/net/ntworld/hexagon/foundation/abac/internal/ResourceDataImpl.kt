package net.ntworld.hexagon.foundation.abac.internal

import net.ntworld.hexagon.foundation.abac.ResourceData

internal data class ResourceDataImpl(
    override val type: String,
    override val id: String,
    override val attributes: Map<String, Any>,
    override val relationships: Map<String, Any>?,
    override val meta: Map<String, Any>?
) : ResourceData
