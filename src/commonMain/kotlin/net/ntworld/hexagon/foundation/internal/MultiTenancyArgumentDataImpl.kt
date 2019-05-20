package net.ntworld.hexagon.foundation.internal

import net.ntworld.hexagon.foundation.ArgumentBuilder
import net.ntworld.hexagon.foundation.ArgumentContext
import net.ntworld.hexagon.foundation.MultiTenancyArgumentData

internal class MultiTenancyArgumentDataImpl(
    private val data: ArgumentBuilder
) : MultiTenancyArgumentData {
    override val uniqueId: String = data.uniqueId

    override val currentTenantId: String = data.currentTenantId as String

    override val currentUserId: String? = data.currentUserId

    override val context: ArgumentContext
        get() {
            return ArgumentContextImpl(
                data.contextEnvironmentType,
                data.contextEnvironmentId,
                data.contextIpAddress,
                data.contextDatetime
            )
        }
}