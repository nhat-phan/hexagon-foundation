package net.ntworld.hexagon.foundation

import kotlinx.coroutines.Deferred

open class HandlerDecoratorAsyncBase<in A : Argument, out R>(
    private val handler: HandlerAsync<A, R>
) : HandlerAsync<A, R> {

    override suspend fun handleAsync(args: A): Deferred<R> {
        return this.handler.handleAsync(args)
    }

}