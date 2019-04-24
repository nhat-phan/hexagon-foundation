package net.ntworld.hexagon.foundation.abac


interface MultiTenancyUser : MultiTenancy {
    override val userId: String

    override val tenantId: String
}