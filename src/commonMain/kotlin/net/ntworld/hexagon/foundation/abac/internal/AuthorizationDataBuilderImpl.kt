package net.ntworld.hexagon.foundation.abac.internal

import net.ntworld.hexagon.foundation.Argument
import net.ntworld.hexagon.foundation.abac.*
import net.ntworld.hexagon.foundation.builder.LinkedHashMapBuilderStorage
import net.ntworld.hexagon.foundation.builder.convertTo
import net.ntworld.hexagon.foundation.validation.assert

internal class AuthorizationDataBuilderImpl : AuthorizationDataBuilder {
    override val builderStorage = LinkedHashMapBuilderStorage()

    override fun copyFrom(argument: Argument): AuthorizationDataBuilder {
        this.subject = makeSubject(argument.currentTenantId, argument.currentUserId)
        this.context = makeContext(
            argument.context.environmentType,
            argument.context.environmentId,
            argument.context.datetime,
            argument.context.ipAddress
        )
        return this
    }

    override fun clearAction(): AuthorizationDataBuilder {
        this.builderStorage.remove(this::action.name)

        return this
    }

    override fun clearResources(): AuthorizationDataBuilder {
        this.builderStorage.set(this::resources.name, mutableListOf<Resource>())

        return this
    }

    override fun withAction(type: String): AuthorizationDataBuilder {
        this.action = makeAction(type.trim())

        return this
    }

    override fun withResource(value: Resource): AuthorizationDataBuilder {
        val resources: Collection<Resource> = this.builderStorage.get(this::resources.name)
        when (resources) {
            is MutableList<Resource> -> resources.add(value)
            else -> throw Exception("Could not add a resource to current collection, please use .clearAuthorizationResource() first.")

        }
        this.resources = resources

        return this
    }

    override fun build(): AuthorizationData {
        return this
            .assert {
                ::subject always required
                ::context required {
                    Context::datetime always required
                    Context::environmentId always required
                    Context::environmentType always required
                    Context::ipAddress always required
                }
                ::action required {
                    Action::type always required
                }
                ::resources always required and pass { it !== null && it.isNotEmpty() }
            }
            .convertTo {
                AuthorizationDataImpl(
                    subject = it.subject,
                    context = it.context,
                    action = it.action,
                    resources = it.resources
                )
            }
    }
}