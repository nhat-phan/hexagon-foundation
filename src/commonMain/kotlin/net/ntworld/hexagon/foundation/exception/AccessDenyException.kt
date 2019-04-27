package net.ntworld.hexagon.foundation.exception

import net.ntworld.hexagon.foundation.Argument
import net.ntworld.hexagon.foundation.abac.AuthorizationData

class AccessDenyException(val argument: Argument, val authorizationData: AuthorizationData) : Exception()