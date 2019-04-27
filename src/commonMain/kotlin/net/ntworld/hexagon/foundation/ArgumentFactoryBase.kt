package net.ntworld.hexagon.foundation

import net.ntworld.hexagon.foundation.exception.ValidationException
import net.ntworld.hexagon.foundation.internal.ArgumentDataImpl
import net.ntworld.hexagon.foundation.internal.MessageBagImpl
import net.ntworld.hexagon.foundation.validator.ArgumentValidator

abstract class ArgumentFactoryBase<out A : Argument>() : ArgumentFactory<ArgumentBuilderBase, A> {
    private val errors: MessageBag = MessageBagImpl()

    abstract fun make(data: ArgumentData): A

    abstract fun validate(builderData: ArgumentBuilderData, errors: MessageBag): Boolean

    final override fun makeArgument(builder: ArgumentBuilderBase): A {
        errors.clear()

        val data = builder.getBuilderData()
        if (ArgumentValidator.validateArgument(data, errors) && validate(data, errors)) {
            return make(ArgumentDataImpl(data))
        }
        throw ValidationException(errors)
    }
}