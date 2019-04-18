package net.ntworld.hexagon.foundation

abstract class ArgumentBuilderBase<out A : Argument> : ArgumentBuilder, ArgumentFactory<A> {
    private var uniqueId: String = ""
    private var contextEnvType: String = ""
    private var contextEnvId: String = ""
    private var contextDatetime: String = ""
    protected val errors: MessageBag = MessageBagImpl()

    abstract fun build(uniqueId: String, context: ArgumentContext): A

    abstract fun validate(): Boolean

    abstract fun resetBuilder()

    override fun reset() {
        this.uniqueId = ""
        this.contextEnvType = ""
        this.contextEnvId = ""
        this.contextDatetime = ""

        this.errors.clear()
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

    private fun validateArgumentData(): Boolean {
        if (this.uniqueId.isBlank()) {
            this.errors.add("uniqueId", "required")
        }

        if (this.contextEnvType.isBlank()) {
            this.errors.add("contextEnvironmentType", "required")
        }

        if (this.contextEnvId.isBlank()) {
            this.errors.add("contextEnvironmentId", "required")
        }

        if (this.contextDatetime.isBlank()) {
            this.errors.add("contextDatetime", "required")
        }

        return this.errors.keys().isEmpty()
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