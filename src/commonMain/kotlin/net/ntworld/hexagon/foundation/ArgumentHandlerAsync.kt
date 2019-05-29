package net.ntworld.hexagon.foundation

import kotlinx.coroutines.Deferred

interface ArgumentHandlerAsync<in A : Argument, out Result> {
    fun handleAsync(argument: A): Deferred<Result>
}