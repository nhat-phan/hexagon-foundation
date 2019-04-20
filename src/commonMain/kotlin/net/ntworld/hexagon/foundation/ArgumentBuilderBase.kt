package net.ntworld.hexagon.foundation

abstract class ArgumentBuilderBase: ArgumentBuilder {
    internal var uniqueId: String = ""
    internal var tenantId: String? = null
    internal var contextEnvType: String = ""
    internal var contextEnvId: String = ""
    internal var contextDatetime: String = ""

    protected abstract fun resetBuilder()

    override fun reset() {
        this.uniqueId = ""
        this.tenantId = null
        this.contextEnvType = ""
        this.contextEnvId = ""
        this.contextDatetime = ""

        this.resetBuilder()
    }

    override fun setUniqueId(value: String) {
        this.uniqueId = value
    }

    override fun setTenantId(value: String) {
        this.tenantId = value
    }

    override fun setContextEnvironment(type: String, id: String) {
        this.contextEnvType = type
        this.contextEnvId = id
    }

    override fun setContextDatetime(value: String) {
        this.contextDatetime = value
    }

//    override fun getBuilderData(): ArgumentBuilderData {
//
//    }
}