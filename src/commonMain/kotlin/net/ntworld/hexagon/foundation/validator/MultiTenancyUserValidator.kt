package net.ntworld.hexagon.foundation.validator

import net.ntworld.hexagon.foundation.ArgumentBuilderData
import net.ntworld.hexagon.foundation.BuilderKey
import net.ntworld.hexagon.foundation.MessageBag

internal object MultiTenancyUserValidator {
    fun validate(data: ArgumentBuilderData, errors: MessageBag): Boolean {
        MultiTenancyValidator.validate(data, errors)

        data.isNotStringOrBlank(BuilderKey.USER_ID.key) {
            errors.add(BuilderKey.USER_ID.key, "required")
        }

        return errors.isEmpty()
    }
}