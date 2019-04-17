package net.ntworld.hexagon.foundation

fun argumentOf(uniqueId: String, context: ArgumentContext): Argument {
    return ArgumentImpl(uniqueId, context)
}

fun argumentOf(uniqueId: String, environmentType: String, environmentId: String, datetime: String): Argument {
    return ArgumentImpl(uniqueId, argumentContextOf(environmentType, environmentId, datetime))
}