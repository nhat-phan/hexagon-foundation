package net.ntworld.hexagon.foundation.abac.internal

import net.ntworld.hexagon.foundation.abac.MultiTenancy

internal data class MultiTenancyImpl(
    override val tenantId: String,
    override val userId: String?
) : MultiTenancy

