package net.ntworld.hexagon.foundation.abac.internal

import net.ntworld.hexagon.foundation.abac.User

internal data class UserImpl(
    override val tenantId: String?,
    override val userId: String
) : User