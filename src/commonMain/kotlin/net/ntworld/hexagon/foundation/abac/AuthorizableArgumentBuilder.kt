package net.ntworld.hexagon.foundation.abac

import net.ntworld.hexagon.foundation.ArgumentBuilder

interface AuthorizableArgumentBuilder : ArgumentBuilder {
    fun copyFrom(argument: AuthorizableArgument): AuthorizableArgumentBuilder

    fun setAuthorizationSubject(value: Subject): AuthorizableArgumentBuilder

    fun setAuthorizationContext(value: Context): AuthorizableArgumentBuilder

    fun setAuthorizationAction(value: Action): AuthorizableArgumentBuilder

    fun setAuthorizationResource(value: Collection<Resource>): AuthorizableArgumentBuilder
}