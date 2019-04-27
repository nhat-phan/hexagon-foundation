package net.ntworld.hexagon.foundation

import net.ntworld.hexagon.foundation.exception.ValidationException
import net.ntworld.hexagon.foundation.internal.MessageBagImpl
import net.ntworld.hexagon.foundation.internal.MultiTenancyArgumentDataImpl
import net.ntworld.hexagon.foundation.validator.ArgumentValidator

abstract class MultiTenancyArgumentFactoryBase<out A : Argument> : ArgumentFactory<ArgumentBuilderBase, A> {
    private val errors: MessageBag = MessageBagImpl()

    abstract fun make(data: MultiTenancyArgumentData): A

    abstract fun validate(data: MultiTenancyArgumentData, errors: MessageBag): Boolean

    final override fun makeArgument(builder: ArgumentBuilderBase): A {
        errors.clear()

        val data = MultiTenancyArgumentDataImpl(builder.getBuilderData())
        if (ArgumentValidator.validateMultiTenancyArgument(data, errors) && validate(data, errors)) {
            return make(data)
        }
        throw ValidationException(errors)
    }
}