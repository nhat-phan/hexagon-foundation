package net.ntworld.hexagon.foundation.abac

interface Authorizer {

    fun authorize(argument: AuthorizableArgument): Boolean

}