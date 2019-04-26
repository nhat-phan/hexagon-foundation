package net.ntworld.hexagon.foundation.internal

import kotlinx.coroutines.Deferred
import net.ntworld.hexagon.foundation.*

internal class PortAsyncImpl<in A : Argument, out B : ArgumentBuilder, out R>(
    private val builder: B,
    private val factory: ArgumentFactory<B, A>
) : PortAsync<A, B, R> {
    private var argument: A? = null
    private var handler: HandlerAsync<A, R>? = null
    private var handlerFactory: ((argument: A) -> HandlerAsync<A, R>)? = null

    constructor(
        builder: B,
        factory: ArgumentFactory<B, A>,
        handler: HandlerAsync<A, R>
    ) : this(builder, factory) {
        this.handler = handler
    }

    constructor(
        builder: B,
        factory: ArgumentFactory<B, A>,
        handlerFactoryFn: (argument: A) -> HandlerAsync<A, R>
    ) : this(builder, factory) {
        this.handlerFactory = handlerFactoryFn
    }

    override fun reset(): PortAsync<A, B, R> {
        this.argument = null
        this.builder.reset()

        return this
    }

    override suspend fun executeAsync(): Deferred<R> {
        return this.handleAsync(this.argument ?: this.factory.make(this.builder))
    }

    override fun use(vararg directors: ArgumentDirector<B>): PortAsync<A, B, R> {
        for (director in directors) {
            director.constructArgument(this.builder)
        }

        return this
    }

    override fun with(constructFn: (builder: B) -> Unit): PortAsync<A, B, R> {
        constructFn(this.builder)

        return this
    }

    override fun with(argument: A): PortAsync<A, B, R> {
        this.argument = argument

        return this
    }

    private fun makeHandler(argument: A): HandlerAsync<A, R> {
        return this.handler ?: this.handlerFactory!!(argument)
    }

    private suspend fun handleAsync(argument: A): Deferred<R> {
        return this.makeHandler(argument).handleAsync(argument)
    }
}
