package net.ntworld.hexagon.foundation.internal

import net.ntworld.hexagon.foundation.ArgumentBuilderData
import net.ntworld.hexagon.foundation.ArgumentContext
import net.ntworld.hexagon.foundation.ArgumentData

internal class ArgumentDataImpl(
    private val data: ArgumentBuilderData
) : ArgumentData, ArgumentBuilderData by data {
    override val uniqueId: String
        get() = this.getValue(BUILDER_KEY_UNIQUE_ID)

    override val currentTenantId: String?
        get() = this.getValue(BUILDER_KEY_CURRENT_TENANT_ID)

    override val currentUserId: String?
        get() = this.getValue(BUILDER_KEY_CURRENT_USER_ID)

    override val context: ArgumentContext
        get() {
            return ArgumentContextImpl(
                this.getValue(BUILDER_KEY_CONTEXT_ENVIRONMENT_TYPE),
                this.getValue(BUILDER_KEY_CONTEXT_ENVIRONMENT_ID),
                this.getValue(BUILDER_KEY_CONTEXT_IP_ADDRESS),
                this.getValue(BUILDER_KEY_CONTEXT_DATETIME)
            )
        }
}