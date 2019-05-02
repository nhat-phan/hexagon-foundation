package net.ntworld.hexagon.foundation.abac

import net.ntworld.hexagon.foundation.Argument

interface AuthorizationDataBuildDirector {
    fun constructAuthorizationData(builder: AuthorizationDataBuilder, argument: Argument)
}
