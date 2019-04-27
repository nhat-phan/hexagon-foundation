package net.ntworld.hexagon.foundation

interface MultiTenancyArgument: Argument {
    override val currentTenantId: String
}