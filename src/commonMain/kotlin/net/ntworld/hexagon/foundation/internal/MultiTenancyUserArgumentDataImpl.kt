package net.ntworld.hexagon.foundation.internal

import net.ntworld.hexagon.foundation.ArgumentBuilder
import net.ntworld.hexagon.foundation.ArgumentContext
import net.ntworld.hexagon.foundation.MultiTenancyUserArgumentData

internal class MultiTenancyUserArgumentDataImpl(
    data: ArgumentBuilder
) : MultiTenancyUserArgumentData {
    override val uniqueId: String = data.uniqueId

    override val currentTenantId: String = data.currentTenantId as String

    override val currentUserId: String = data.currentUserId as String

    override val context: ArgumentContext = ArgumentContextImpl(
        data.contextEnvironmentType,
        data.contextEnvironmentId,
        data.contextIpAddress,
        data.contextDatetime
    )
}