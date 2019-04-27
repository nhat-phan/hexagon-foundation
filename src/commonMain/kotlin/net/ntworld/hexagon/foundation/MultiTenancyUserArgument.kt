package net.ntworld.hexagon.foundation

interface MultiTenancyUserArgument: MultiTenancyArgument {
    override val currentUserId: String
}