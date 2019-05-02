package net.ntworld.hexagon.foundation

import kotlinx.coroutines.Deferred

interface PortAsync<out B : ArgumentBuilder, out R> {
    fun reset(): PortAsync<B, R>

    fun use(vararg directors: ArgumentBuildDirector<B>): PortAsync<B, R>

    fun with(constructFn: (builder: B) -> Unit): PortAsync<B, R>

    fun executeAsync(): Deferred<R>
}