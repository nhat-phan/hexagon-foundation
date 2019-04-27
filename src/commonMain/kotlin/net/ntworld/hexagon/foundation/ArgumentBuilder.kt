package net.ntworld.hexagon.foundation

interface ArgumentBuilder {
    fun reset(): ArgumentBuilder

    fun setUniqueId(value: String): ArgumentBuilder

    fun setCurrentUserId(value: String): ArgumentBuilder

    fun setCurrentTenantId(value: String): ArgumentBuilder

    fun setContextEnvironment(type: String, id: String): ArgumentBuilder

    fun setContextDatetime(value: String): ArgumentBuilder

    fun setContextIpAddress(value: String): ArgumentBuilder
}