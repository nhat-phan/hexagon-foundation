package net.ntworld.hexagon.foundation.abac

import net.ntworld.hexagon.foundation.abac.internal.*

fun <T : Subject> makeAuthorizationData(
    subject: T,
    context: Context,
    action: Action?,
    resources: Collection<Resource>?
): AuthorizationData<T> {
    return AuthorizationDataImpl<T>(subject, context, action, resources)
}

fun makeAction(type: String): Action {
    return ActionImpl(type)
}

fun actionCreate(): Action {
    return ActionEnum.CREATE
}

fun actionUpdate(): Action {
    return ActionEnum.UPDATE
}

fun actionDelete(): Action {
    return ActionEnum.DELETE
}

fun actionRead(): Action {
    return ActionEnum.READ
}

fun makeAuthorizationContext(
    environmentType: String,
    environmentId: String,
    datetime: String,
    ipAddress: String,
    location: String?
): Context {
    return ContextImpl(environmentType, environmentId, datetime, ipAddress, location)
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

fun guest(): Subject {
    return SubjectImpl(null, null);
}

fun user(userId: String): User {
    return UserImpl(null, userId)
}

fun guestOf(tenantId: String): MultiTenancy {
    return MultiTenancyImpl(tenantId, null);
}

fun userOf(tenantId: String, userId: String): MultiTenancyUser {
    return MultiTenancyUserImpl(tenantId, userId);
}

fun makeAuthorizationSubject(tenantId: String?, userId: String?): Subject {
    return SubjectImpl(tenantId, userId);
}
