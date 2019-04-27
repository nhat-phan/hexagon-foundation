package net.ntworld.hexagon.foundation.abac

import net.ntworld.hexagon.foundation.Argument
import net.ntworld.hexagon.foundation.ArgumentBuilder
import net.ntworld.hexagon.foundation.abac.internal.ActionEnum

interface AuthorizationDataBuilder : ArgumentBuilder {
    fun copyFrom(argument: Argument): AuthorizationDataBuilder

    fun setSubject(value: Subject): AuthorizationDataBuilder

    fun setContext(value: Context): AuthorizationDataBuilder

    fun setAction(value: Action): AuthorizationDataBuilder

    fun setResources(value: Collection<Resource>): AuthorizationDataBuilder

    fun clearAction(): AuthorizationDataBuilder

    fun clearResources(): AuthorizationDataBuilder

    fun withAction(type: String): AuthorizationDataBuilder

    fun withCreateAction(): AuthorizationDataBuilder = this.withAction(ActionEnum.CREATE.type)

    fun withUpdateAction(): AuthorizationDataBuilder = this.withAction(ActionEnum.UPDATE.type)

    fun withReadAction(): AuthorizationDataBuilder = this.withAction(ActionEnum.READ.type)

    fun withDeleteAction(): AuthorizationDataBuilder = this.withAction(ActionEnum.DELETE.type)

    fun withResource(value: Resource): AuthorizationDataBuilder

    fun build(): AuthorizationData
}