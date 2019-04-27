package net.ntworld.hexagon.foundation

import kotlinx.coroutines.Deferred

interface PortAsync<out B : ArgumentBuilder, out R> {
    fun reset(): PortAsync<B, R>

    fun use(vararg directors: ArgumentDirector<B>): PortAsync<B, R>

    fun with(constructFn: (builder: B) -> Unit): PortAsync<B, R>

    suspend fun executeAsync(): Deferred<R>
}