package net.ntworld.hexagon.foundation.validator

import net.ntworld.hexagon.foundation.ArgumentBuilderData
import net.ntworld.hexagon.foundation.MessageBag
import net.ntworld.hexagon.foundation.abac.Action
import net.ntworld.hexagon.foundation.abac.Context
import net.ntworld.hexagon.foundation.abac.Resource
import net.ntworld.hexagon.foundation.abac.Subject
import net.ntworld.hexagon.foundation.abac.internal.BUILDER_KEY_AUTHORIZATION_ACTION
import net.ntworld.hexagon.foundation.abac.internal.BUILDER_KEY_AUTHORIZATION_CONTEXT
import net.ntworld.hexagon.foundation.abac.internal.BUILDER_KEY_AUTHORIZATION_RESOURCES
import net.ntworld.hexagon.foundation.abac.internal.BUILDER_KEY_AUTHORIZATION_SUBJECT
import net.ntworld.hexagon.foundation.internal.MESSAGE_REQUIRED

object AuthorizationDataValidator {

    fun validate(data: ArgumentBuilderData, errors: MessageBag): Boolean {
        if (data[BUILDER_KEY_AUTHORIZATION_SUBJECT] !is Subject) {
            errors.add(BUILDER_KEY_AUTHORIZATION_SUBJECT, MESSAGE_REQUIRED)
        }

        if (data[BUILDER_KEY_AUTHORIZATION_CONTEXT] !is Context) {
            errors.add(BUILDER_KEY_AUTHORIZATION_CONTEXT, MESSAGE_REQUIRED)
        }

        val action: Any? = data.getValue(BUILDER_KEY_AUTHORIZATION_ACTION)
        if (action !is Action || action.type.isBlank()) {
            errors.add(BUILDER_KEY_AUTHORIZATION_ACTION, MESSAGE_REQUIRED)
        }

        val resources: Collection<Resource>? = data.getValue(BUILDER_KEY_AUTHORIZATION_RESOURCES)
        if (resources !is Collection<Resource> || resources.isEmpty()) {
            errors.add(BUILDER_KEY_AUTHORIZATION_RESOURCES, MESSAGE_REQUIRED)
        }

        return errors.isEmpty()
    }

}