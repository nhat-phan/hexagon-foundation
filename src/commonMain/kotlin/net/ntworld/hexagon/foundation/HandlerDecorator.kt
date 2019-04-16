package net.ntworld.hexagon.foundation

open class HandlerDecorator<in A : Argument, out R>(
    private val wrappee: Handler<A, R>
) : Handler<A, R> {

    override fun handle(args: A): R {
        return this.wrappee.handle(args)
    }

}