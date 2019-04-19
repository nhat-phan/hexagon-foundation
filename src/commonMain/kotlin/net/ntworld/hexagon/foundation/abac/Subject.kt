package net.ntworld.hexagon.foundation.abac

interface Subject {
    val multiTenancy: Boolean
        get() = null !== tenantId

    val tenantId: String?

    val hasUser: Boolean
        get() = null !== userId

    val userId: String?

    val isGuest: Boolean
        get() = null === userId
}