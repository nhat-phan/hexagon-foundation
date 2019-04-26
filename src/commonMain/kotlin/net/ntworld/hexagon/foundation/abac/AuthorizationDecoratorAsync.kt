package net.ntworld.hexagon.foundation.abac

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import net.ntworld.hexagon.foundation.HandlerAsync
import net.ntworld.hexagon.foundation.HandlerDecoratorAsync
import net.ntworld.hexagon.foundation.exception.AccessDenyException

class AuthorizationDecoratorAsync<out R>(
    private val wrappee: HandlerAsync<AuthorizableArgument, R>,
    private val authorizer: AuthorizerAsync
) : HandlerDecoratorAsync<AuthorizableArgument, R>(wrappee) {

    override suspend fun handleAsync(args: AuthorizableArgument): Deferred<R> {
        val hasAccess: Boolean = authorizer.authorizeAsync(args.authorizationData).await()
        if (!hasAccess) {
            throw AccessDenyException(args)
        }

        return wrappee.handleAsync(args)
    }

}