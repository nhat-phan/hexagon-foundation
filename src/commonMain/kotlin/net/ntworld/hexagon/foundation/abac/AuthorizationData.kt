package net.ntworld.hexagon.foundation.abac

interface AuthorizationData {
    val subject: Subject

    val context: Context

    val action: Action

    val resources: Collection<Resource>
}