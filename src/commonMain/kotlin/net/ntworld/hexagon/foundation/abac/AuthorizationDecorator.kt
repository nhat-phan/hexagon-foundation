package net.ntworld.hexagon.foundation.abac

import net.ntworld.hexagon.foundation.Handler
import net.ntworld.hexagon.foundation.HandlerDecorator
import net.ntworld.hexagon.foundation.exception.AccessDenyException

class AuthorizationDecorator<out R>(
    private val wrappee: Handler<AuthorizableArgument, R>,
    private val authorizer: Authorizer
) : HandlerDecorator<AuthorizableArgument, R>(wrappee) {

    override fun handle(args: AuthorizableArgument): R {
        val hasAccess: Boolean = authorizer.authorize(args.authorizationData)
        if (!hasAccess) {
            throw AccessDenyException(args)
        }

        return wrappee.handle(args)
    }

}