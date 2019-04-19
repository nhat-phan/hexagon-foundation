package net.ntworld.hexagon.foundation

import net.ntworld.hexagon.foundation.exception.ValidationException

abstract class MultiTenancyArgumentBuilderBase<out A : MultiTenancyArgument> : ArgumentBuilder, ArgumentFactory<A> {
    private var uniqueId: String = ""
    private var tenantId: String = ""
    private var contextEnvType: String = ""
    private var contextEnvId: String = ""
    private var contextDatetime: String = ""
    protected val errors: MessageBag = MessageBagImpl()

    abstract fun build(uniqueId: String, tenantId: String, context: ArgumentContext): A

    abstract fun validate(): Boolean

    abstract fun resetBuilder()

    override fun reset() {
        this.uniqueId = ""
        this.tenantId = ""
        this.contextEnvType = ""
        this.contextEnvId = ""
        this.contextDatetime = ""

        this.errors.clear()
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

    protected open fun validateArgumentData(): Boolean {
        if (this.uniqueId.isBlank()) {
            this.errors.add("uniqueId", "required")
        }

        if (this.tenantId.isBlank()) {
            this.errors.add("tenantId", "required")
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

        return this.errors.isEmpty()
    }

    override fun make(): A {
        if (this.validateArgumentData() && this.validate()) {
            return this.build(
                this.uniqueId,
                this.tenantId,
                makeArgumentContext(this.contextEnvType, this.contextEnvId, this.contextDatetime)
            )
        }
        throw ValidationException(this.errors)
    }
}