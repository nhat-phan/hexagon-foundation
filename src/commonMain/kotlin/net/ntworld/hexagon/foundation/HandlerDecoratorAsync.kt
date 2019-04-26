package net.ntworld.hexagon.foundation

import kotlinx.coroutines.Deferred

open class HandlerDecoratorAsync<in A : Argument, out R>(
    private val wrappee: HandlerAsync<A, R>
) : HandlerAsync<A, R> {

    override suspend fun handleAsync(args: A): Deferred<R> {
        return this.wrappee.handleAsync(args)
    }

}