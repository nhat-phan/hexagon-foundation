package net.ntworld.hexagon.foundation.abac.internal

import net.ntworld.hexagon.foundation.abac.Resource

internal data class ResourceImpl(
    override val type: String
) : Resource {
    override val id: String? = null
    override val attributes: Map<String, Any>? = null
    override val relationships: Map<String, Any>? = null
    override val meta: Map<String, Any>? = null
}
