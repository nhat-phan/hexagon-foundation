package net.ntworld.hexagon.foundation.abac

interface Subject {
    val hasMultiTenancy: Boolean
        get() = null !== multiTenancyId

    val multiTenancyId: String?

    val hasUser: Boolean
        get() = null !== userId

    val userId: String?

    val isGuest: Boolean
        get() = null === userId
}