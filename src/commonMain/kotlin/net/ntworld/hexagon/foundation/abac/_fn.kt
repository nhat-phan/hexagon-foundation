package net.ntworld.hexagon.foundation.abac

import net.ntworld.hexagon.foundation.Argument
import net.ntworld.hexagon.foundation.ArgumentHandler
import net.ntworld.hexagon.foundation.ArgumentHandlerAsync
import net.ntworld.hexagon.foundation.abac.internal.ActionImpl
import net.ntworld.hexagon.foundation.abac.internal.ContextImpl
import net.ntworld.hexagon.foundation.abac.internal.ResourceDataImpl
import net.ntworld.hexagon.foundation.abac.internal.ResourceImpl
import net.ntworld.hexagon.foundation.abac.internal.SubjectImpl

fun makeSubject(tenantId: String?, userId: String?): Subject {
    return SubjectImpl(tenantId, userId);
}

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

fun <A : Argument, R, T> ArgumentHandler<A, R>.authorizeBy(
    authorizer: T
): ArgumentHandler<A, R> where T : Authorizer, T : AuthorizationDataBuildDirector {
    return AuthorizationDecorator(this, authorizer, listOf(authorizer))
}

fun <A : Argument, R> ArgumentHandler<A, R>.authorizeBy(
    authorizer: Authorizer,
    director: AuthorizationDataBuildDirector
): ArgumentHandler<A, R> {
    return AuthorizationDecorator(this, authorizer, listOf(director))
}

fun <A : Argument, R> ArgumentHandler<A, R>.authorizeBy(
    authorizer: Authorizer,
    director: AuthorizationDataBuildDirector,
    vararg otherDirectors: AuthorizationDataBuildDirector
): ArgumentHandler<A, R> {
    return AuthorizationDecorator(this, authorizer, listOf(director) + otherDirectors)
}

fun <A : Argument, R, T> ArgumentHandlerAsync<A, R>.authorizeBy(
    authorizer: T
): ArgumentHandlerAsync<A, R> where T : AuthorizerAsync, T : AuthorizationDataBuildDirectorAsync {
    return AuthorizationDecoratorAsync(this, authorizer, listOf(authorizer))
}

fun <A : Argument, R> ArgumentHandlerAsync<A, R>.authorizeBy(
    authorizer: AuthorizerAsync,
    director: AuthorizationDataBuildDirectorAsync
): ArgumentHandlerAsync<A, R> {
    return AuthorizationDecoratorAsync(this, authorizer, listOf(director))
}

fun <A : Argument, R> ArgumentHandlerAsync<A, R>.authorizeBy(
    authorizer: AuthorizerAsync,
    director: AuthorizationDataBuildDirectorAsync,
    vararg otherDirectors: AuthorizationDataBuildDirectorAsync
): ArgumentHandlerAsync<A, R> {
    return AuthorizationDecoratorAsync(this, authorizer, listOf(director) + otherDirectors)
}