package net.ntworld.hexagon.foundation

internal class PortImpl<in A : Argument, out B : ArgumentBuilder, out R>(
    private val builder: B,
    private val factory: ArgumentFactory<A>
) : Port<A, B, R> {
    private var argument: A? = null
    private var handler: Handler<A, R>? = null
    private var handlerFactory: ((argument: A) -> Handler<A, R>)? = null
    private var enhancer: ((handler: Handler<A, R>) -> Handler<A, R>)? = null
    private var enhancerWithArgs: ((handler: Handler<A, R>, argument: A) -> Handler<A, R>)? = null

    constructor(
        builder: B,
        factory: ArgumentFactory<A>,
        handler: Handler<A, R>
    ) : this(builder, factory) {
        this.handler = handler
    }

    constructor(
        builder: B,
        factory: ArgumentFactory<A>,
        handlerFactoryFn: (argument: A) -> Handler<A, R>
    ) : this(builder, factory) {
        this.handlerFactory = handlerFactoryFn
    }

    constructor(
        builder: B,
        factory: ArgumentFactory<A>,
        handler: Handler<A, R>,
        enhanceFn: (handler: Handler<A, R>) -> Handler<A, R>
    ) : this(builder, factory) {
        this.handler = handler
        this.enhancer = enhanceFn
    }

    constructor(
        builder: B,
        factory: ArgumentFactory<A>,
        handler: Handler<A, R>,
        enhanceFn: (handler: Handler<A, R>, argument: A) -> Handler<A, R>
    ) : this(builder, factory) {
        this.handler = handler
        this.enhancerWithArgs = enhanceFn
    }

    override fun reset(): Port<A, B, R> {
        this.argument = null
        this.builder.reset()

        return this
    }

    override fun execute(): R {
        return this.handle(this.argument ?: this.factory.make())
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

    fun makeHandler(argument: A): Handler<A, R> {
        return this.handler ?: this.handlerFactory!!(argument)
    }

    fun handle(argument: A): R {
        val handler = this.makeHandler(argument)
        if (this.enhancer === null && this.enhancerWithArgs === null) {
            return handler.handle(argument)
        }

        if (this.enhancer === null) {
            return this.enhancerWithArgs!!(handler, argument).handle(argument)
        }

        return this.enhancer!!(handler).handle(argument)
    }
}
