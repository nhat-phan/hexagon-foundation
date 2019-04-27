package net.ntworld.hexagon.foundation.abac

import net.ntworld.hexagon.foundation.abac.internal.ActionImpl
import net.ntworld.hexagon.foundation.abac.internal.ContextImpl
import net.ntworld.hexagon.foundation.abac.internal.ResourceDataImpl
import net.ntworld.hexagon.foundation.abac.internal.ResourceImpl
import net.ntworld.hexagon.foundation.abac.internal.SubjectImpl

fun makeAction(type: String): Action {
    return ActionImpl(type)
}


fun makeContext(
    environmentType: String,
    environmentId: String,
    datetime: String,
    ipAddress: String
): Context {
    return ContextImpl(environmentType, environmentId, datetime, ipAddress)
}

fun makeResource(type: String): Resource {
    return ResourceImpl(type)
}

fun makeResource(
    type: String,
    id: String,
    attributes: Map<String, Any>,
    relationships: Map<String, Any>? = null,
    meta: Map<String, Any>? = null
): Resource {
    return ResourceDataImpl(type, id, attributes, relationships, meta)
}

fun makeSubject(tenantId: String?, userId: String?): Subject {
    return SubjectImpl(tenantId, userId);
}