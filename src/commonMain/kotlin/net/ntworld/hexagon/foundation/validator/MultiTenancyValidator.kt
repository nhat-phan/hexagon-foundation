package net.ntworld.hexagon.foundation.validator

import net.ntworld.hexagon.foundation.ArgumentBuilderData
import net.ntworld.hexagon.foundation.BuilderKey
import net.ntworld.hexagon.foundation.MessageBag

internal object MultiTenancyValidator {
    fun validate(data: ArgumentBuilderData, errors: MessageBag): Boolean {
        ArgumentValidator.validate(data, errors)

        data.isNotStringOrBlank(BuilderKey.TENANT_ID.key) {
            errors.add(BuilderKey.TENANT_ID.key, "required")
        }

        return errors.isEmpty()
    }
}