package net.ntworld.hexagon.foundation.abac

interface MultiTenancy: Subject {
    override val tenantId: String
}