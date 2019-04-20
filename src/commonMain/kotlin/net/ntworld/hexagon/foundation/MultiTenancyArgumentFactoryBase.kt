package net.ntworld.hexagon.foundation

import net.ntworld.hexagon.foundation.exception.ValidationException

abstract class MultiTenancyArgumentFactoryBase<out A : MultiTenancyArgument> :
    ArgumentFactory<ArgumentBuilderBase, A> {
    protected val errors: MessageBag = MessageBagImpl()

    abstract fun build(uniqueId: String, tenantId: String, context: ArgumentContext, data: ArgumentBuilderData): A

    abstract fun validate(data: ArgumentBuilderData): Boolean

    protected open fun validateArgumentData(data: ArgumentBuilderData): Boolean {
        this.errors.clear()

        if (data.uniqueId.isNullOrBlank()) {
            this.errors.add("uniqueId", "required")
        }

        if (data.tenantId.isNullOrBlank()) {
            this.errors.add("tenantId", "required")
        }

        if (data.contextEnvironmentType.isNullOrBlank()) {
            this.errors.add("contextEnvironmentType", "required")
        }

        if (data.contextEnvironmentId.isNullOrBlank()) {
            this.errors.add("contextEnvironmentId", "required")
        }

        if (data.contextDatetime.isNullOrBlank()) {
            this.errors.add("contextDatetime", "required")
        }

        return this.errors.isEmpty()
    }

    override fun make(builder: ArgumentBuilderBase): A {
        val data = builder.getBuilderData()
        if (this.validateArgumentData(data) && this.validate(data)) {
            return this.build(
                data.uniqueId as String,
                data.tenantId as String,
                makeArgumentContext(
                    data.contextEnvironmentType as String,
                    data.contextEnvironmentId as String,
                    data.contextDatetime as String
                ),
                data
            )
        }
        throw ValidationException(this.errors)
    }
}