package net.ntworld.hexagon.foundation.abac.internal

import net.ntworld.hexagon.foundation.abac.*

internal data class AuthorizationDataImpl<T : Subject>(
    override val subject: T,
    override val context: Context,
    override val action: Action?,
    override val resources: Collection<Resource>?
) : AuthorizationData<T>