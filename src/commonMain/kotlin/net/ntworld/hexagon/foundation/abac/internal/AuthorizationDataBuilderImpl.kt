package net.ntworld.hexagon.foundation.abac.internal

import net.ntworld.hexagon.foundation.Argument
import net.ntworld.hexagon.foundation.ArgumentBuilderBase
import net.ntworld.hexagon.foundation.MessageBag
import net.ntworld.hexagon.foundation.abac.*
import net.ntworld.hexagon.foundation.exception.ValidationException
import net.ntworld.hexagon.foundation.internal.MessageBagImpl
import net.ntworld.hexagon.foundation.validator.AuthorizationDataValidator

internal class AuthorizationDataBuilderImpl : ArgumentBuilderBase(), AuthorizationDataBuilder {
    override fun copyFrom(argument: Argument): AuthorizationDataBuilder {
        this.setSubject(makeSubject(argument.currentTenantId, argument.currentUserId))
        this.setContext(
            makeContext(
                argument.context.environmentType,
                argument.context.environmentId,
                argument.context.datetime,
                argument.context.ipAddress
            )
        )
        return this
    }

    override fun setSubject(value: Subject): AuthorizationDataBuilder {
        this[BUILDER_KEY_AUTHORIZATION_SUBJECT] = value

        return this
    }

    override fun setContext(value: Context): AuthorizationDataBuilder {
        this[BUILDER_KEY_AUTHORIZATION_CONTEXT] = value

        return this
    }

    override fun setAction(value: Action): AuthorizationDataBuilder {
        this[BUILDER_KEY_AUTHORIZATION_ACTION] = value

        return this
    }

    override fun setResources(value: Collection<Resource>): AuthorizationDataBuilder {
        this[BUILDER_KEY_AUTHORIZATION_RESOURCES] = value

        return this
    }

    override fun clearAction(): AuthorizationDataBuilder {
        this.remove(BUILDER_KEY_AUTHORIZATION_ACTION)

        return this
    }

    override fun clearResources(): AuthorizationDataBuilder {
        this.remove(BUILDER_KEY_AUTHORIZATION_RESOURCES)

        return this
    }

    override fun withAction(type: String): AuthorizationDataBuilder {
        this[BUILDER_KEY_AUTHORIZATION_ACTION] = makeAction(type.trim())

        return this
    }

    override fun withResource(value: Resource): AuthorizationDataBuilder {
        val resources: Collection<Resource> = this.getValue(BUILDER_KEY_AUTHORIZATION_RESOURCES, mutableListOf())
        when (resources) {
            is MutableList<Resource> -> resources.add(value)
            else -> throw Exception("Could not add a resource to current collection, please use .clearAuthorizationResource() first.")

        }
        this[BUILDER_KEY_AUTHORIZATION_RESOURCES] = resources

        return this
    }

    override fun build(): AuthorizationData {
        val errors: MessageBag = MessageBagImpl()

        val data = this.getBuilderData()
        if (AuthorizationDataValidator.validate(data, errors)) {
            return AuthorizationDataImpl(
                subject = data.getValue(BUILDER_KEY_AUTHORIZATION_SUBJECT),
                context = data.getValue(BUILDER_KEY_AUTHORIZATION_CONTEXT),
                action = data.getValue(BUILDER_KEY_AUTHORIZATION_ACTION),
                resources = data.getValue(BUILDER_KEY_AUTHORIZATION_RESOURCES)
            )
        }
        throw ValidationException(errors)
    }
}