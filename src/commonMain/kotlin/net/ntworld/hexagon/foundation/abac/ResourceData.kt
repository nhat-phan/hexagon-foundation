package net.ntworld.hexagon.foundation.abac

interface ResourceData : Resource {
    override val id: String

    override val attributes: Map<String, Any>
}