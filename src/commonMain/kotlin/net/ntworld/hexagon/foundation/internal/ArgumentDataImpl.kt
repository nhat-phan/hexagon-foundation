package net.ntworld.hexagon.foundation.internal

import net.ntworld.hexagon.foundation.ArgumentBuilder
import net.ntworld.hexagon.foundation.ArgumentContext
import net.ntworld.hexagon.foundation.ArgumentData

internal class ArgumentDataImpl(
    data: ArgumentBuilder
) : ArgumentData {
    override val uniqueId: String = data.uniqueId

    override val currentTenantId: String? = data.currentTenantId

    override val currentUserId: String? = data.currentUserId

    override val context: ArgumentContext = ArgumentContextImpl(
        data.contextEnvironmentType,
        data.contextEnvironmentId,
        data.contextIpAddress,
        data.contextDatetime
    )
}