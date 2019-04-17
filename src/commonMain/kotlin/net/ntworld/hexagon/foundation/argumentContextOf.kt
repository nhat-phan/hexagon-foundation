package net.ntworld.hexagon.foundation

fun argumentContextOf(environmentType: String, environmentId: String, datetime: String): ArgumentContext {
    return ArgumentContextImpl(environmentType, environmentId, datetime)
}