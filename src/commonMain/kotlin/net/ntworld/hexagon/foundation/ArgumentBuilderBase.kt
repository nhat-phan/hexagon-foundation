package net.ntworld.hexagon.foundation

abstract class ArgumentBuilderBase : ArgumentBuilder {
    private val data: MutableMap<String, Any> = mutableMapOf()

    protected fun set(key: String, value: String) {
        this.data[key] = value
    }

    override fun reset() {
        this.data.clear()
    }

    override fun setUniqueId(value: String) {
        data["uniqueId"] = value
    }

    override fun setTenantId(value: String) {
        data["tenantId"] = value
    }

    override fun setContextEnvironment(type: String, id: String) {
        data["contextEnvironmentType"] = type
        data["contextEnvironmentId"] = id
    }

    override fun setContextDatetime(value: String) {
        data["contextDatetime"] = value
    }

    fun getBuilderData(): ArgumentBuilderData {
        return argumentBuilderDataOf(this.data.toMap())
    }
}