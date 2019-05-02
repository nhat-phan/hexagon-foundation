package net.ntworld.hexagon.foundation.abac

import kotlinx.coroutines.Deferred

interface AuthorizerAsync {

    fun authorizeAsync(data: AuthorizationData): Deferred<Boolean>

}