package net.ntworld.hexagon.foundation

internal data class ArgumentImpl(
    override val uniqueId: String,
    override val tenantId: String?,
    override val context: ArgumentContext
) : Argument

fun makeArgument(uniqueId: String, tenantId: String?, context: ArgumentContext): Argument {
    return ArgumentImpl(uniqueId, tenantId, context)
}

fun makeArgument(
    uniqueId: String,
    tenantId: String?,
    environmentType: String,
    environmentId: String,
    datetime: String
): Argument {
    return ArgumentImpl(uniqueId, tenantId, makeArgumentContext(environmentType, environmentId, datetime))
}