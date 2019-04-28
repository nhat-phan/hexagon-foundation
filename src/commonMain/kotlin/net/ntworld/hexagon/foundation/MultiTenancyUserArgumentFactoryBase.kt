package net.ntworld.hexagon.foundation

import net.ntworld.hexagon.foundation.exception.ValidationException
import net.ntworld.hexagon.foundation.internal.MessageBagImpl
import net.ntworld.hexagon.foundation.internal.MultiTenancyUserArgumentDataImpl
import net.ntworld.hexagon.foundation.validator.ArgumentValidator

abstract class MultiTenancyUserArgumentFactoryBase<out A : Argument> : ArgumentFactory<ArgumentBuilderBase, A> {
    private val errors: MessageBag = MessageBagImpl()

    abstract fun make(data: MultiTenancyUserArgumentData): A

    abstract fun validate(data: MultiTenancyUserArgumentData, errors: MessageBag): Boolean

    final override fun makeArgument(builder: ArgumentBuilderBase): A {
        errors.clear()

        val data = MultiTenancyUserArgumentDataImpl(builder.getBuilderData())
        if (ArgumentValidator.validateMultiTenancyUserArgument(data, errors) && validate(data, errors)) {
            return make(data)
        }
        throw ValidationException(errors)
    }
}