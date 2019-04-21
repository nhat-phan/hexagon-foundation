package net.ntworld.hexagon.foundation.validator

import net.ntworld.hexagon.foundation.ArgumentBuilderData
import net.ntworld.hexagon.foundation.BuilderKey
import net.ntworld.hexagon.foundation.MessageBag

internal object ArgumentValidator {
    fun validateUniqueId(data: ArgumentBuilderData, errors: MessageBag) {
        if (data.uniqueId.isNullOrBlank()) {
            errors.add(BuilderKey.UNIQUE_ID.key, "required")
        }
    }

    fun validateContext(data: ArgumentBuilderData, errors: MessageBag) {
        if (data.contextEnvironmentType.isNullOrBlank()) {
            errors.add(BuilderKey.CONTEXT_ENVIRONMENT_TYPE.key, "required")
        }

        if (data.contextEnvironmentId.isNullOrBlank()) {
            errors.add(BuilderKey.CONTEXT_ENVIRONMENT_ID.key, "required")
        }

        if (data.contextDatetime.isNullOrBlank()) {
            errors.add(BuilderKey.CONTEXT_DATETIME.key, "required")
        }
    }

    fun validate(data: ArgumentBuilderData, errors: MessageBag): Boolean {
        validateUniqueId(data, errors)
        validateContext(data, errors)

        return errors.isEmpty()
    }
}