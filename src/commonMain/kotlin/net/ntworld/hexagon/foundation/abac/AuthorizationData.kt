package net.ntworld.hexagon.foundation.abac

interface AuthorizationData<out T: Subject> {
    val subject: T

    val context: Context

    val action: Action?

    val resources: Collection<Resource>?
}