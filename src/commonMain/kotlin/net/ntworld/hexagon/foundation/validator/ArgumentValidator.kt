package net.ntworld.hexagon.foundation.validator

import net.ntworld.hexagon.foundation.ArgumentBuilderData
import net.ntworld.hexagon.foundation.MessageBag
import net.ntworld.hexagon.foundation.internal.*

internal object ArgumentValidator {
    private fun validateUniqueId(data: ArgumentBuilderData, errors: MessageBag) {
        data.isNotStringOrBlank(BUILDER_KEY_UNIQUE_ID) {
            errors.add(BUILDER_KEY_UNIQUE_ID, MESSAGE_REQUIRED)
        }
    }

    private fun validateContext(data: ArgumentBuilderData, errors: MessageBag) {
        data.isNotStringOrBlank(BUILDER_KEY_CONTEXT_ENVIRONMENT_TYPE) {
            errors.add(BUILDER_KEY_CONTEXT_ENVIRONMENT_TYPE, MESSAGE_REQUIRED)
        }

        data.isNotStringOrBlank(BUILDER_KEY_CONTEXT_ENVIRONMENT_ID) {
            errors.add(BUILDER_KEY_CONTEXT_ENVIRONMENT_ID, MESSAGE_REQUIRED)
        }

        data.isNotStringOrBlank(BUILDER_KEY_CONTEXT_DATETIME) {
            errors.add(BUILDER_KEY_CONTEXT_DATETIME, MESSAGE_REQUIRED)
        }

        data.isNotStringOrBlank(BUILDER_KEY_CONTEXT_IP_ADDRESS) {
            errors.add(BUILDER_KEY_CONTEXT_IP_ADDRESS, MESSAGE_REQUIRED)
        }
    }

    private fun validateCurrentTenantId(data: ArgumentBuilderData, errors: MessageBag) {
        data.isNotStringOrBlank(BUILDER_KEY_CURRENT_TENANT_ID) {
            errors.add(BUILDER_KEY_CURRENT_TENANT_ID, MESSAGE_REQUIRED)
        }
    }

    private fun validateCurrentUserId(data: ArgumentBuilderData, errors: MessageBag) {
        data.isNotStringOrBlank(BUILDER_KEY_CURRENT_USER_ID) {
            errors.add(BUILDER_KEY_CURRENT_USER_ID, MESSAGE_REQUIRED)
        }
    }

    fun validateArgument(data: ArgumentBuilderData, errors: MessageBag): Boolean {
        validateUniqueId(data, errors)
        validateContext(data, errors)

        return errors.isEmpty()
    }

    fun validateUserArgument(data: ArgumentBuilderData, errors: MessageBag): Boolean {
        validateUniqueId(data, errors)
        validateCurrentUserId(data, errors)
        validateContext(data, errors)

        return errors.isEmpty()
    }

    fun validateMultiTenancyArgument(data: ArgumentBuilderData, errors: MessageBag): Boolean {
        validateUniqueId(data, errors)
        validateCurrentTenantId(data, errors)
        validateContext(data, errors)

        return errors.isEmpty()
    }

    fun validateMultiTenancyUserArgument(data: ArgumentBuilderData, errors: MessageBag): Boolean {
        validateUniqueId(data, errors)
        validateCurrentTenantId(data, errors)
        validateCurrentUserId(data, errors)
        validateContext(data, errors)

        return errors.isEmpty()
    }
}