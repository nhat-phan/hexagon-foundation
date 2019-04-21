package net.ntworld.hexagon.foundation.abac.internal

import net.ntworld.hexagon.foundation.abac.MultiTenancyUser

internal data class MultiTenancyUserImpl(
    override val tenantId: String,
    override val userId: String
) : MultiTenancyUser

