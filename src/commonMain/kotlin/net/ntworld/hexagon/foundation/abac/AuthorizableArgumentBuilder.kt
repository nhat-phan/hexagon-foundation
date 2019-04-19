package net.ntworld.hexagon.foundation.abac

import net.ntworld.hexagon.foundation.ArgumentBuilder

interface AuthorizableArgumentBuilder : ArgumentBuilder {
    fun copyFrom(argument: AuthorizableArgument): AuthorizableArgumentBuilder

    fun setAuthorizationSubject(value: Subject): AuthorizableArgumentBuilder

    fun setAuthorizationContext(value: Context): AuthorizableArgumentBuilder

    fun setAuthorizationAction(value: Action): AuthorizableArgumentBuilder

    fun setAuthorizationResource(value: Collection<Resource>): AuthorizableArgumentBuilder

    fun clearAuthorizationAction(): AuthorizableArgumentBuilder

    fun clearAuthorizationResource(): AuthorizableArgumentBuilder

    fun withAction(action: String): AuthorizableArgumentBuilder

    fun withAction(action: ActionEnum): AuthorizableArgumentBuilder = this.withAction(action.type)

    fun withCreateAction(): AuthorizableArgumentBuilder = this.withAction(ActionEnum.CREATE)

    fun withUpdateAction(): AuthorizableArgumentBuilder = this.withAction(ActionEnum.UPDATE)

    fun withReadAction(): AuthorizableArgumentBuilder = this.withAction(ActionEnum.READ)

    fun withDeleteAction(): AuthorizableArgumentBuilder = this.withAction(ActionEnum.DELETE)

    fun withResource(value: Resource): AuthorizableArgumentBuilder
}