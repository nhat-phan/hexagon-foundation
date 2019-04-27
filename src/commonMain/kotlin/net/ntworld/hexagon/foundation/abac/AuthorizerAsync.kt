package net.ntworld.hexagon.foundation.abac

import kotlinx.coroutines.Deferred

interface AuthorizerAsync {

    suspend fun authorizeAsync(data: AuthorizationData): Deferred<Boolean>

}