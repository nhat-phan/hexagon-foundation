package net.ntworld.hexagon.foundation

import kotlinx.coroutines.Deferred

interface PortAsync<in A : Argument, out B : ArgumentBuilder, out R> {
    fun reset(): PortAsync<A, B, R>

    fun use(vararg directors: ArgumentDirector<B>): PortAsync<A, B, R>

    fun with(constructFn: (builder: B) -> Unit): PortAsync<A, B, R>

    fun with(argument: A): PortAsync<A, B, R>

    fun executeAsync(): Deferred<R>
}