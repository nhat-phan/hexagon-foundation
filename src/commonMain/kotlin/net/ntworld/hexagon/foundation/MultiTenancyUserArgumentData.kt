package net.ntworld.hexagon.foundation

interface MultiTenancyUserArgumentData {
    val uniqueId: String

    val currentUserId: String

    val currentTenantId: String

    val context: ArgumentContext
}