package net.ntworld.hexagon.foundation

interface ArgumentData : ArgumentBuilderData {
    val uniqueId: String

    val currentUserId: String?

    val currentTenantId: String?

    val context: ArgumentContext
}