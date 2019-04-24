package net.ntworld.hexagon.foundation

import net.ntworld.hexagon.foundation.exception.ValidationException
import net.ntworld.hexagon.foundation.internal.MessageBagImpl
import net.ntworld.hexagon.foundation.validator.ArgumentValidator

abstract class ArgumentFactoryBase<A : Argument> : ArgumentFactory<ArgumentBuilderBase, A> {
    protected val errors: MessageBag = MessageBagImpl()

    abstract fun build(uniqueId: String, context: ArgumentContext, data: ArgumentBuilderData): A

    abstract fun validate(data: ArgumentBuilderData): Boolean

    override fun make(builder: ArgumentBuilderBase): A {
        val data = builder.getBuilderData()

        this.errors.clear()
        if (ArgumentValidator.validate(data, errors) && this.validate(data)) {
            return this.build(
                data.uniqueId as String,
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