package net.ntworld.hexagon.foundation.internal

import net.ntworld.hexagon.foundation.*
import net.ntworld.hexagon.foundation.exception.ValidationException

internal class PortImpl2<in A : Argument, out B : ArgumentBuilder, out R> private constructor(
    private val builder: B,
    private val validators: List<ArgumentValidator<B>>,
    private val factory: ArgumentFactory<B, A>
) : Port<B, R> {
    private var handler: Handler<A, R>? = null
    private var handlerFactory: ((argument: A) -> Handler<A, R>)? = null

    constructor(
        builder: B,
        validators: List<ArgumentValidator<B>>,
        factory: ArgumentFactory<B, A>,
        handler: Handler<A, R>
    ) : this(builder, validators, factory) {
        this.handler = handler
    }

    constructor(
        builder: B,
        validators: List<ArgumentValidator<B>>,
        factory: ArgumentFactory<B, A>,
        handlerFactoryFn: (argument: A) -> Handler<A, R>
    ) : this(builder, validators, factory) {
        this.handlerFactory = handlerFactoryFn
    }

    override fun reset(): Port<B, R> {
        this.builder.reset()

        return this
    }

    override fun use(vararg directors: ArgumentBuildDirector<B>): Port<B, R> {
        for (director in directors) {
            director.constructArgument(builder)
        }

        return this
    }

    override fun with(constructFn: (builder: B) -> Unit): Port<B, R> {
        constructFn(this.builder)

        return this
    }

    override fun execute(): R {
        this.assertBuilderIsValid()

        return this.handle(this.factory.makeArgument(this.builder))
    }

    private fun assertBuilderIsValid() {
        val errors = MessageBagImpl()
        val isValid = validators
            .map { it.validate(builder) }
            .fold(true) { acc, result ->
                if (result.isValid) {
                    return@fold acc
                }

                errors += result.errors
                return@fold false
            }

        if (!isValid) {
            throw ValidationException(errors)
        }
    }

    private fun makeHandler(argument: A): Handler<A, R> {
        return this.handler ?: this.handlerFactory!!(argument)
    }

    private fun handle(argument: A): R {
        return this.makeHandler(argument).handle(argument)
    }
}
