package net.ntworld.hexagon.foundation.abac

interface Resource {
    val type: String

    val hasData: Boolean
        get() = null !== this.id

    val id: String?

    val attributes: Map<String, Any>?

    val relationships: Map<String, Any>?

    val meta: Map<String, Any>?
}