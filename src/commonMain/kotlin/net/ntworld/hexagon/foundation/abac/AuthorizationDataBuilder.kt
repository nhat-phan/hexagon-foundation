package net.ntworld.hexagon.foundation.abac

import net.ntworld.hexagon.foundation.Argument
import net.ntworld.hexagon.foundation.ArgumentBuilder
import net.ntworld.hexagon.foundation.abac.internal.ActionEnum
import net.ntworld.hexagon.foundation.abac.internal.AuthorizationDataBuilderDelegate

interface AuthorizationDataBuilder : ArgumentBuilder {
    fun copyFrom(argument: Argument): AuthorizationDataBuilder

    var subject: Subject
        get() {
            return AuthorizationDataBuilderDelegate.subject.getValue(this, this::subject)
        }
        set(value) {
            return AuthorizationDataBuilderDelegate.subject.setValue(this, this::subject, value)
        }

    var context: Context
        get() {
            return AuthorizationDataBuilderDelegate.context.getValue(this, this::context)
        }
        set(value) {
            return AuthorizationDataBuilderDelegate.context.setValue(this, this::context, value)
        }

    var action: Action
        get() {
            return AuthorizationDataBuilderDelegate.action.getValue(this, this::action)
        }
        set(value) {
            return AuthorizationDataBuilderDelegate.action.setValue(this, this::action, value)
        }

    var resources: Collection<Resource>
        get() {
            return AuthorizationDataBuilderDelegate.resources.getValue(this, this::resources)
        }
        set(value) {
            return AuthorizationDataBuilderDelegate.resources.setValue(this, this::resources, value)
        }

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