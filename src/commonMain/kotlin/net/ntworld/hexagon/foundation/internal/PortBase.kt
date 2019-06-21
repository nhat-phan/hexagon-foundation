package net.ntworld.hexagon.foundation.internal

import net.ntworld.hexagon.foundation.*
import net.ntworld.kotlin.validator.exception.ValidationException

internal abstract class PortBase<in A : Argument, out B : ArgumentBuilder, out R> protected constructor(
    private val builder: B,
    private val validator: ArgumentValidator<B>?,
    private val factory: ArgumentFactory<B, A>
) : Port<B, R> {
    override fun use(director: ArgumentBuildDirector<B>): Port<B, R> {
        director.constructArgument(builder)

        return this
    }

    override fun with(block: B.() -> Unit): R {
        builder.apply(block)
        if (null !== this.validator) {
            val validationResult = this.validator.validate(builder)
            if (!validationResult.isValid) {
                throw ValidationException(validationResult.errors)
            }
        }
        val result = this.execute(this.factory.makeArgument(builder))
        this.reset()

        return result
    }

    private fun reset(): Port<B, R> {
        this.builder.reset()

        return this
    }

    abstract fun execute(argument: A): R
}