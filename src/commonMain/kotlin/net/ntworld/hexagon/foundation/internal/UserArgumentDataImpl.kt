package net.ntworld.hexagon.foundation.internal

import net.ntworld.hexagon.foundation.ArgumentBuilder
import net.ntworld.hexagon.foundation.ArgumentContext
import net.ntworld.hexagon.foundation.UserArgumentData

internal class UserArgumentDataImpl(
    data: ArgumentBuilder
) : UserArgumentData {
    override val uniqueId: String = data.uniqueId

    override val currentTenantId: String? = data.currentTenantId

    override val currentUserId: String = data.currentUserId as String

    override val context = ArgumentContextImpl(
        data.contextEnvironmentType,
        data.contextEnvironmentId,
        data.contextIpAddress,
        data.contextDatetime
    )
}