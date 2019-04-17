package net.ntworld.hexagon.foundation

abstract class ArgumentBuilderBase<out A : Argument> : ArgumentBuilder, ArgumentFactory<A> {
    private var uniqueId: String = ""
    private var contextEnvType: String = ""
    private var contextEnvId: String = ""
    private var contextDatetime: String = ""

    abstract fun build(uniqueId: String, context: ArgumentContext): A

    abstract fun validate(): Boolean

    abstract fun resetBuilder()

    override fun reset() {
        this.uniqueId = ""
        this.contextEnvType = ""
        this.contextEnvId = ""
        this.contextDatetime = ""
        this.resetBuilder()
    }

    override fun setUniqueId(value: String) {
        this.uniqueId = value
    }

    override fun setContextEnvironment(type: String, id: String) {
        this.contextEnvType = type
        this.contextEnvId = id
    }

    override fun setContextDatetime(value: String) {
        this.contextDatetime = value
    }

    fun validateArgumentData(): Boolean {
        return true
    }

    override fun make(): A {
        if (this.validateArgumentData() && this.validate()) {
            return this.build(
                this.uniqueId,
                argumentContextOf(this.contextEnvType, this.contextEnvId, this.contextDatetime)
            )
        }
        throw Exception("")
    }
}