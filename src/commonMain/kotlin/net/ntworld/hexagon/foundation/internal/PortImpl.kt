package net.ntworld.hexagon.foundation.internal

import net.ntworld.hexagon.foundation.*

internal class PortImpl<in A : Argument, out B : ArgumentBuilder, out R>(
    private val builder: B,
    private val factory: ArgumentFactory<B, A>
) : Port<A, B, R> {
    private var argument: A? = null
    private var handler: Handler<A, R>? = null
    private var handlerFactory: ((argument: A) -> Handler<A, R>)? = null

    constructor(
            builder: B,
            factory: ArgumentFactory<B, A>,
            handler: Handler<A, R>
    ) : this(builder, factory) {
        this.handler = handler
    }

    constructor(
            builder: B,
            factory: ArgumentFactory<B, A>,
            handlerFactoryFn: (argument: A) -> Handler<A, R>
    ) : this(builder, factory) {
        this.handlerFactory = handlerFactoryFn
    }

    override fun reset(): Port<A, B, R> {
        this.argument = null
        this.builder.reset()

        return this
    }

    override fun execute(): R {
        return this.handle(this.argument ?: this.factory.make(this.builder))
    }

    override fun use(vararg directors: ArgumentDirector<B>): Port<A, B, R> {
        for (director in directors) {
            director.constructArgument(this.builder)
        }

        return this
    }

    override fun with(constructFn: (builder: B) -> Unit): Port<A, B, R> {
        constructFn(this.builder)

        return this
    }

    override fun with(argument: A): Port<A, B, R> {
        this.argument = argument

        return this
    }

    private fun makeHandler(argument: A): Handler<A, R> {
        return this.handler ?: this.handlerFactory!!(argument)
    }

    private fun handle(argument: A): R {
        return this.makeHandler(argument).handle(argument)
    }
}
