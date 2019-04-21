package net.ntworld.hexagon.foundation.validator

import net.ntworld.hexagon.foundation.ArgumentBuilderData
import net.ntworld.hexagon.foundation.BuilderKey
import net.ntworld.hexagon.foundation.MessageBag

internal object AuthorizableArgumentValidator {
    fun validate(data: ArgumentBuilderData, errors: MessageBag): Boolean {
        ArgumentValidator.validateUniqueId(data, errors)

        val context = data[BuilderKey.AUTHORIZATION_CONTEXT.key]
        if (null === context) {
            ArgumentValidator.validateContext(data, errors)

            data.isNotStringOrBlank(BuilderKey.CONTEXT_IP_ADDRESS.key) {
                errors.add(BuilderKey.CONTEXT_IP_ADDRESS.key, "required")
            }
        }

        return errors.isEmpty()
    }
}