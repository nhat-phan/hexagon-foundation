package net.ntworld.hexagon.foundation

import kotlinx.coroutines.Deferred

interface HandlerAsync<in A : Argument, out Result> {
    fun handleAsync(args: A): Deferred<Result>
}