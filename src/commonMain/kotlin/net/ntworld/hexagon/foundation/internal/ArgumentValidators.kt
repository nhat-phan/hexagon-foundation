package net.ntworld.hexagon.foundation.internal

import net.ntworld.hexagon.foundation.ArgumentBuilder
import net.ntworld.hexagon.foundation.validation.Validator

internal object ArgumentValidators {
    val default = Validator<ArgumentBuilder> {
        ArgumentBuilder::uniqueId always required
        ArgumentBuilder::contextEnvironmentType always required
        ArgumentBuilder::contextEnvironmentId always required
        ArgumentBuilder::contextDatetime always required
        ArgumentBuilder::contextIpAddress always required
    }

    val multiTenancy = Validator<ArgumentBuilder> {
        ArgumentBuilder::currentTenantId always required
    }

    val user = Validator<ArgumentBuilder> {
        ArgumentBuilder::currentUserId always required
    }
}


