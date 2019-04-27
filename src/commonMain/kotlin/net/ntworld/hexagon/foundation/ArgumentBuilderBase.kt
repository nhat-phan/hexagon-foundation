package net.ntworld.hexagon.foundation

import net.ntworld.hexagon.foundation.internal.*

open class ArgumentBuilderBase(
    private val data: MutableMap<String, Any> = mutableMapOf()
) : ArgumentBuilder, MutableMap<String, Any> by data {
    override fun reset(): ArgumentBuilder {
        data.clear()

        return this
    }

    protected fun <T> getValue(key: String): T {
        @Suppress("UNCHECKED_CAST")
        return this.data[key] as T
    }

    protected fun <T> getValue(key: String, defaultValue: T): T {
        val value = this.data[key]
        if (null === value) {
            return defaultValue
        }
        @Suppress("UNCHECKED_CAST")
        return value as T
    }

    final override fun setUniqueId(value: String): ArgumentBuilder {
        data[BUILDER_KEY_UNIQUE_ID] = value.trim()

        return this
    }

    final override fun setCurrentUserId(value: String): ArgumentBuilder {
        data[BUILDER_KEY_CURRENT_USER_ID] = value.trim()

        return this
    }

    final override fun setCurrentTenantId(value: String): ArgumentBuilder {
        data[BUILDER_KEY_CURRENT_TENANT_ID] = value.trim()

        return this
    }

    final override fun setContextEnvironment(type: String, id: String): ArgumentBuilder {
        data[BUILDER_KEY_CONTEXT_ENVIRONMENT_TYPE] = type.trim()
        data[BUILDER_KEY_CONTEXT_ENVIRONMENT_ID] = id.trim()

        return this
    }

    final override fun setContextDatetime(value: String): ArgumentBuilder {
        data[BUILDER_KEY_CONTEXT_DATETIME] = value.trim()

        return this
    }

    final override fun setContextIpAddress(value: String): ArgumentBuilder {
        data[BUILDER_KEY_CONTEXT_IP_ADDRESS] = value.trim()

        return this
    }

    fun getBuilderData(): ArgumentBuilderData {
        return ArgumentBuilderDataImpl(data)
    }
}