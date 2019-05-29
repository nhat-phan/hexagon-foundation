package net.ntworld.hexagon.foundation

import kotlinx.coroutines.Deferred

open class HandlerDecoratorAsyncBase<in A : Argument, out R>(
    private val handler: ArgumentHandlerAsync<A, R>
) : ArgumentHandlerAsync<A, R> {

    override fun handleAsync(argument: A): Deferred<R> {
        return this.handler.handleAsync(argument)
    }

}