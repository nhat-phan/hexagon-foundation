package net.ntworld.hexagon.foundation.abac

import net.ntworld.hexagon.foundation.Argument

interface AuthorizationDataDirector {
    fun constructAuthorizationData(builder: AuthorizationDataBuilder, argument: Argument)
}
