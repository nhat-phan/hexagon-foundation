package net.ntworld.hexagon.foundation.abac


interface MultiTenancyUser : Subject {
    override val userId: String

    override val tenantId: String
}