package net.ntworld.hexagon.foundation.abac

data class ResourceImpl(
    override val type: String,
    override val id: String?,
    override val attributes: Map<String, Any>?,
    override val relationships: Map<String, Any>?,
    override val meta: Map<String, Any>?
) : Resource

fun makeResource(
    type: String,
    id: String? = null,
    attributes: Map<String, Any>? = null,
    relationships: Map<String, Any>?,
    meta: Map<String, Any>? = null
): Resource {
    return ResourceImpl(type, id, attributes, relationships, meta)
}