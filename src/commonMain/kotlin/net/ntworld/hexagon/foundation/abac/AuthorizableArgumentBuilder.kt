package net.ntworld.hexagon.foundation.abac

import net.ntworld.hexagon.foundation.ArgumentBuilder
import net.ntworld.hexagon.foundation.abac.internal.ActionEnum

interface AuthorizableArgumentBuilder : ArgumentBuilder {
    fun copyFrom(argument: AuthorizableArgument): AuthorizableArgumentBuilder

    fun setAuthorizationSubject(value: Subject): AuthorizableArgumentBuilder

    fun setAuthorizationContext(value: Context): AuthorizableArgumentBuilder

    fun setAuthorizationAction(value: Action): AuthorizableArgumentBuilder

    fun setAuthorizationResource(value: Collection<Resource>): AuthorizableArgumentBuilder

    fun setTenantId(value: String): AuthorizableArgumentBuilder

    fun setUserId(value: String): AuthorizableArgumentBuilder

    fun setContextIpAddress(value: String): AuthorizableArgumentBuilder

    fun setContextLocation(value: String): AuthorizableArgumentBuilder

    fun clearAuthorizationAction(): AuthorizableArgumentBuilder

    fun clearAuthorizationResource(): AuthorizableArgumentBuilder

    fun withAction(type: String): AuthorizableArgumentBuilder

    fun withCreateAction(): AuthorizableArgumentBuilder = this.withAction(ActionEnum.CREATE.type)

    fun withUpdateAction(): AuthorizableArgumentBuilder = this.withAction(ActionEnum.UPDATE.type)

    fun withReadAction(): AuthorizableArgumentBuilder = this.withAction(ActionEnum.READ.type)

    fun withDeleteAction(): AuthorizableArgumentBuilder = this.withAction(ActionEnum.DELETE.type)

    fun withResource(value: Resource): AuthorizableArgumentBuilder
}