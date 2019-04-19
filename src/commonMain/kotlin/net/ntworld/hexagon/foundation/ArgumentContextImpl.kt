package net.ntworld.hexagon.foundation

internal data class ArgumentContextImpl(
    override val environmentType: String,
    override val environmentId: String,
    override val datetime: String
) : ArgumentContext

fun makeArgumentContext(environmentType: String, environmentId: String, datetime: String): ArgumentContext {
    return ArgumentContextImpl(environmentType, environmentId, datetime)
}