package net.ntworld.hexagon.foundation

import kotlinx.coroutines.Deferred

interface HandlerAsync<in A : Argument, out Result> {
    suspend fun handleAsync(args: A): Deferred<Result>
}