package net.ntworld.hexagon.foundation

interface Argument {
    val multiTenancy: Boolean
        get() = null !== tenantId

    val tenantId: String?

    val uniqueId: String

    val context: ArgumentContext
}