package net.ntworld.hexagon.foundation.exception

import net.ntworld.hexagon.foundation.abac.AuthorizableArgument

class AccessDenyException(val argument: AuthorizableArgument) : Exception()