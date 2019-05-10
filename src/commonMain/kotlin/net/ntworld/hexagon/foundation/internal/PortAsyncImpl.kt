package net.ntworld.hexagon.foundation.internal

import kotlinx.coroutines.Deferred
import net.ntworld.hexagon.foundation.*

internal class PortAsyncImpl<in A : Argument, out B : ArgumentBuilder, out R> private constructor(
    builder: B,
    validator: ArgumentValidator<B>?,
    factory: ArgumentFactory<B, A>
) : PortBase<A, B, Deferred<R>>(builder, validator, factory) {
    private var handler: HandlerAsync<A, R>? = null
    private var handlerFactory: ((argument: A) -> HandlerAsync<A, R>)? = null

    constructor(
        builder: B,
        validator: ArgumentValidator<B>?,
        factory: ArgumentFactory<B, A>,
        handler: HandlerAsync<A, R>
    ) : this(builder, validator, factory) {
        this.handler = handler
    }

    constructor(
        builder: B,
        validator: ArgumentValidator<B>?,
        factory: ArgumentFactory<B, A>,
        handlerFactoryFn: (argument: A) -> HandlerAsync<A, R>
    ) : this(builder, validator, factory) {
        this.handlerFactory = handlerFactoryFn
    }

    override fun execute(argument: A): Deferred<R> {
        val handler = this.handler ?: this.handlerFactory!!(argument)

        return handler.handleAsync(argument)
    }
}
