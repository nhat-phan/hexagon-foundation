package net.ntworld.hexagon.foundation.abac

interface Authorizer {

    fun authorize(data: AuthorizationData): Boolean

}
