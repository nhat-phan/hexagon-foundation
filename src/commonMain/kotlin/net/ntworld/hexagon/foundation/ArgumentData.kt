package net.ntworld.hexagon.foundation

interface ArgumentData {
    val uniqueId: String

    val currentUserId: String?

    val currentTenantId: String?

    val context: ArgumentContext
}