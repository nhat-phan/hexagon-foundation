package net.ntworld.hexagon.foundation

interface UserArgumentData {
    val uniqueId: String

    val currentUserId: String

    val currentTenantId: String?

    val context: ArgumentContext
}