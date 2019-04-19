package net.ntworld.hexagon.foundation.abac

internal data class ContextImpl(
    override val environmentType: String,
    override val environmentId: String,
    override val datetime: String,
    override val ipAddress: String,
    override val location: String?
) : Context

fun makeAuthorizationContext(
    environmentType: String,
    environmentId: String,
    datetime: String,
    ipAddress: String,
    location: String?
): Context {
    return ContextImpl(
        environmentType,
        environmentId,
        datetime,
        ipAddress,
        location
    )
}