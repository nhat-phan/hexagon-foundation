package net.ntworld.hexagon.foundation.abac

import net.ntworld.hexagon.foundation.ArgumentBuilderBase
import net.ntworld.hexagon.foundation.BuilderKey

open class AuthorizableArgumentBuilderBase : ArgumentBuilderBase(), AuthorizableArgumentBuilder {
    override fun copyFrom(argument: AuthorizableArgument): AuthorizableArgumentBuilder {
        val data = argument.authorizationData

        this.setUniqueId(argument.uniqueId)
        this.setAuthorizationSubject(makeAuthorizationSubject(data.subject.tenantId, data.subject.userId))
        this.setAuthorizationContext(
            makeAuthorizationContext(
                data.context.environmentType,
                data.context.environmentId,
                data.context.datetime,
                data.context.ipAddress,
                data.context.location
            )
        )

        val action = data.action
        if (null !== action) {
            this.withAction(action.type)
        }

        val resources = data.resources
        if (null !== resources && resources.isNotEmpty()) {
            for (resource in resources) {
                this.withResource(resource)
            }
        }

        return this
    }

    override fun setAuthorizationSubject(value: Subject): AuthorizableArgumentBuilder {
        this.set(BuilderKey.AUTHORIZATION_SUBJECT.key, value)

        return this
    }

    override fun setAuthorizationContext(value: Context): AuthorizableArgumentBuilder {
        this.set(BuilderKey.AUTHORIZATION_CONTEXT.key, value)

        return this
    }

    override fun setAuthorizationAction(value: Action): AuthorizableArgumentBuilder {
        this.set(BuilderKey.AUTHORIZATION_ACTION.key, value)

        return this
    }

    override fun setAuthorizationResource(value: Collection<Resource>): AuthorizableArgumentBuilder {
        this.set(BuilderKey.AUTHORIZATION_RESOURCES.key, value)

        return this
    }

    override fun setTenantId(value: String): AuthorizableArgumentBuilder {
        this.set(BuilderKey.TENANT_ID.key, value)

        return this
    }

    override fun setUserId(value: String): AuthorizableArgumentBuilder {
        this.set(BuilderKey.USER_ID.key, value)

        return this
    }

    override fun setContextIpAddress(value: String): AuthorizableArgumentBuilder {
        this.set(BuilderKey.CONTEXT_IP_ADDRESS.key, value)

        return this
    }

    override fun setContextLocation(value: String): AuthorizableArgumentBuilder {
        this.set(BuilderKey.CONTEXT_LOCATION.key, value)

        return this
    }

    override fun clearAuthorizationAction(): AuthorizableArgumentBuilder {
        this.remove(BuilderKey.AUTHORIZATION_ACTION.key)

        return this
    }

    override fun clearAuthorizationResource(): AuthorizableArgumentBuilder {
        this.remove(BuilderKey.AUTHORIZATION_RESOURCES.key)

        return this
    }

    override fun withAction(type: String): AuthorizableArgumentBuilder {
        this.set(BuilderKey.AUTHORIZATION_ACTION.key, makeAction(type))

        return this
    }

    override fun withResource(value: Resource): AuthorizableArgumentBuilder {
        val resources: Collection<Resource> = this.get(BuilderKey.AUTHORIZATION_RESOURCES.key, mutableListOf())
        when (resources) {
            is MutableList<Resource> -> resources.add(value)
            else -> throw Exception("Could not add a resource to current collection, please use .clearAuthorizationResource() first.")
        }
        this.set(BuilderKey.AUTHORIZATION_RESOURCES.key, resources)

        return this
    }
}