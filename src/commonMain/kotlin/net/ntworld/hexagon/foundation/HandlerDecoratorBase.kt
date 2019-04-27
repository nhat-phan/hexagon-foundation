package net.ntworld.hexagon.foundation

open class HandlerDecoratorBase<in A : Argument, out R>(
    private val handler: Handler<A, R>
) : Handler<A, R> {

    override fun handle(argument: A): R {
        return this.handler.handle(argument)
    }

}