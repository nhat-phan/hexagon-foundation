package net.ntworld.hexagon.foundation.abac

import net.ntworld.hexagon.foundation.Argument
import net.ntworld.hexagon.foundation.Handler
import net.ntworld.hexagon.foundation.HandlerAsync
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

fun <A : Argument, R, T> Handler<A, R>.authorizeBy(
    authorizer: T
): Handler<A, R> where T : Authorizer, T : AuthorizationDataDirector {
    return AuthorizationDecorator(this, authorizer, listOf(authorizer))
}

fun <A : Argument, R> Handler<A, R>.authorizeBy(
    authorizer: Authorizer,
    director: AuthorizationDataDirector
): Handler<A, R> {
    return AuthorizationDecorator(this, authorizer, listOf(director))
}

fun <A : Argument, R> Handler<A, R>.authorizeBy(
    authorizer: Authorizer,
    director: AuthorizationDataDirector,
    vararg otherDirectors: AuthorizationDataDirector
): Handler<A, R> {
    return AuthorizationDecorator(this, authorizer, listOf(director) + otherDirectors)
}

fun <A : Argument, R, T> HandlerAsync<A, R>.authorizeBy(
    authorizer: T
): HandlerAsync<A, R> where T : AuthorizerAsync, T : AuthorizationDataDirectorAsync {
    return AuthorizationDecoratorAsync(this, authorizer, listOf(authorizer))
}

fun <A : Argument, R> HandlerAsync<A, R>.authorizeBy(
    authorizer: AuthorizerAsync,
    director: AuthorizationDataDirectorAsync
): HandlerAsync<A, R> {
    return AuthorizationDecoratorAsync(this, authorizer, listOf(director))
}

fun <A : Argument, R> HandlerAsync<A, R>.authorizeBy(
    authorizer: AuthorizerAsync,
    director: AuthorizationDataDirectorAsync,
    vararg otherDirectors: AuthorizationDataDirectorAsync
): HandlerAsync<A, R> {
    return AuthorizationDecoratorAsync(this, authorizer, listOf(director) + otherDirectors)
}