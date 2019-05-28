package net.ntworld.hexagon.foundation

interface MultiTenancyArgumentData : MultiTenancyArgument {
    override val currentTenantId: String
}