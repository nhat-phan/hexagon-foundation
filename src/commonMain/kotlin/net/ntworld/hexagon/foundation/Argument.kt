package net.ntworld.hexagon.foundation

interface Argument {
    val uniqueId: String

    val currentUserId: String?

    val currentTenantId: String?

    val context: ArgumentContext
}