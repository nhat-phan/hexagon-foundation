package net.ntworld.hexagon.foundation

import net.ntworld.hexagon.foundation.exception.ValidationException
import net.ntworld.hexagon.foundation.internal.MessageBagImpl
import net.ntworld.hexagon.foundation.internal.UserArgumentDataImpl
import net.ntworld.hexagon.foundation.validator.ArgumentValidator

abstract class UserArgumentFactoryBase<out A : Argument> : ArgumentFactory<ArgumentBuilderBase, A> {
    private val errors: MessageBag = MessageBagImpl()

    abstract fun make(data: UserArgumentData): A

    abstract fun validate(data: UserArgumentData, errors: MessageBag): Boolean

    final override fun makeArgument(builder: ArgumentBuilderBase): A {
        errors.clear()

        val data = UserArgumentDataImpl(builder.getBuilderData())
        if (ArgumentValidator.validateUserArgument(data, errors) && validate(data, errors)) {
            return make(data)
        }
        throw ValidationException(errors)
    }
}