package net.ntworld.hexagon.foundation.abac

import net.ntworld.hexagon.foundation.Argument

interface AuthorizationDataBuildDirectorAsync {
    suspend fun constructAuthorizationDataAsync(builder: AuthorizationDataBuilder, argument: Argument)
}
