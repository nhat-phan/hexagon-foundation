package net.ntworld.hexagon.foundation.abac

import net.ntworld.hexagon.foundation.ArgumentContext

interface Context : ArgumentContext {
    val ipAddress: String

    val location: String?
}