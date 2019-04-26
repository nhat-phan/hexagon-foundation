package net.ntworld.hexagon.foundation

open class ArgumentBuilderBase : ArgumentBuilder {
    private val data: MutableMap<String, Any> = mutableMapOf()

    protected fun set(key: String, value: Any) {
        this.data[key] = value
    }

    protected fun <T> get(key: String): T {
        @Suppress("UNCHECKED_CAST")
        return this.data[key] as T
    }

    protected fun <T> get(key: String, defaultValue: T): T {
        val value = this.data[key]
        if (null === value) {
            return defaultValue
        }
        @Suppress("UNCHECKED_CAST")
        return value as T
    }

    protected fun remove(key: String) {
        this.data.remove(key)
    }

    override fun reset() {
        this.data.clear()
    }

    override fun setUniqueId(value: String): ArgumentBuilder {
        data[BuilderKey.UNIQUE_ID.key] = value

        return this
    }

    override fun setContextEnvironment(type: String, id: String): ArgumentBuilder {
        data[BuilderKey.CONTEXT_ENVIRONMENT_TYPE.key] = type
        data[BuilderKey.CONTEXT_ENVIRONMENT_ID.key] = id

        return this
    }

    override fun setContextDatetime(value: String): ArgumentBuilder {
        data[BuilderKey.CONTEXT_DATETIME.key] = value

        return this
    }

    open fun getBuilderData(): ArgumentBuilderData {
        return argumentBuilderDataOf(this.data.toMap())
    }
}