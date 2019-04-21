package net.ntworld.hexagon.foundation

internal data class ArgumentImpl(
    override val uniqueId: String,
    override val context: ArgumentContext
) : Argument

fun makeArgument(uniqueId: String, context: ArgumentContext): Argument {
    return ArgumentImpl(uniqueId, context)
}

fun makeArgument(
    uniqueId: String,
    environmentType: String,
    environmentId: String,
    datetime: String
): Argument {
    return ArgumentImpl(uniqueId, makeArgumentContext(environmentType, environmentId, datetime))
}