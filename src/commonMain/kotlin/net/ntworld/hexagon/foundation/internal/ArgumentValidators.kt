package net.ntworld.hexagon.foundation.internal

import net.ntworld.hexagon.foundation.ArgumentBuilder
import net.ntworld.kotlin.validator.validator

internal object ArgumentValidators {
    val default = validator<ArgumentBuilder> {
        ArgumentBuilder::uniqueId always required
        ArgumentBuilder::contextEnvironmentType always required
        ArgumentBuilder::contextEnvironmentId always required
        ArgumentBuilder::contextDatetime always required
        ArgumentBuilder::contextIpAddress always required
    }

    val multiTenancy = validator<ArgumentBuilder> {
        ArgumentBuilder::currentTenantId always required
    }

    val user = validator<ArgumentBuilder> {
        ArgumentBuilder::currentUserId always required
    }
}


