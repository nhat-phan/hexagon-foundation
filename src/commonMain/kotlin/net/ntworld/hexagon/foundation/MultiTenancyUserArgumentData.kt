package net.ntworld.hexagon.foundation

interface MultiTenancyUserArgumentData : MultiTenancyUserArgument {
    override val currentUserId: String

    override val currentTenantId: String
}