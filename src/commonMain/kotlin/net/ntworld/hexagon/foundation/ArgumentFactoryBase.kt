package net.ntworld.hexagon.foundation

import net.ntworld.hexagon.foundation.exception.ValidationException

abstract class ArgumentFactoryBase<B: ArgumentBuilderBase, A: Argument>: ArgumentFactory<B, A> {
    protected val errors: MessageBag = MessageBagImpl()

    abstract fun build(uniqueId: String, tenantId: String?, context: ArgumentContext, builder: B): A

    abstract fun validate(builder: B): Boolean

    protected open fun validateArgumentData(builder: B): Boolean {
        this.errors.clear()

        if (builder.uniqueId.isBlank()) {
            this.errors.add("uniqueId", "required")
        }

        if (builder.contextEnvType.isBlank()) {
            this.errors.add("contextEnvironmentType", "required")
        }

        if (builder.contextEnvId.isBlank()) {
            this.errors.add("contextEnvironmentId", "required")
        }

        if (builder.contextDatetime.isBlank()) {
            this.errors.add("contextDatetime", "required")
        }

        return this.errors.isEmpty()
    }

    override fun make(builder: B): A {
        if (this.validateArgumentData(builder) && this.validate(builder)) {
            return this.build(
                builder.uniqueId,
                builder.tenantId,
                makeArgumentContext(builder.contextEnvType, builder.contextEnvId, builder.contextDatetime),
                builder
            )
        }
        throw ValidationException(this.errors)
    }
}