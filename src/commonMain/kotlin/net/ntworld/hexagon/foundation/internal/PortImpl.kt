package net.ntworld.hexagon.foundation.internal

import net.ntworld.hexagon.foundation.*

internal class PortImpl<in A : Argument, out B : ArgumentBuilder, out R> private constructor(
    builder: B,
    validator: ArgumentValidator<B>?,
    factory: ArgumentFactory<B, A>
) : PortBase<A, B, R>(builder, validator, factory) {
    private var handler: ArgumentHandler<A, R>? = null
    private var handlerFactory: ((argument: A) -> ArgumentHandler<A, R>)? = null

    constructor(
        builder: B,
        validator: ArgumentValidator<B>?,
        factory: ArgumentFactory<B, A>,
        handler: ArgumentHandler<A, R>
    ) : this(builder, validator, factory) {
        this.handler = handler
    }

    constructor(
        builder: B,
        validator: ArgumentValidator<B>?,
        factory: ArgumentFactory<B, A>,
        handlerFactoryFn: (argument: A) -> ArgumentHandler<A, R>
    ) : this(builder, validator, factory) {
        this.handlerFactory = handlerFactoryFn
    }

    override fun execute(argument: A): R {
        val handler = this.handler ?: this.handlerFactory!!(argument)

        return handler.handle(argument)
    }
}
