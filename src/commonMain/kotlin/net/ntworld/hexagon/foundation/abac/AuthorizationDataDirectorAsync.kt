package net.ntworld.hexagon.foundation.abac

import net.ntworld.hexagon.foundation.Argument

interface AuthorizationDataDirectorAsync {
    suspend fun constructAuthorizationDataAsync(builder: AuthorizationDataBuilder, argument: Argument)
}
