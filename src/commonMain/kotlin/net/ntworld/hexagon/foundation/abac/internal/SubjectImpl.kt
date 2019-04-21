package net.ntworld.hexagon.foundation.abac.internal

import net.ntworld.hexagon.foundation.abac.Subject

internal data class SubjectImpl(
    override val tenantId: String?,
    override val userId: String?
) : Subject

