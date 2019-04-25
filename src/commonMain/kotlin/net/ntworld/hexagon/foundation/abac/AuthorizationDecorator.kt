package net.ntworld.hexagon.foundation.abac

import net.ntworld.hexagon.foundation.Handler
import net.ntworld.hexagon.foundation.HandlerDecorator
import net.ntworld.hexagon.foundation.exception.AccessDenyException

class AuthorizationDecorator<out R>(
        private val wrappee: Handler<AuthorizableArgument, R>,
        private val authorizer: Authorizer
) : HandlerDecorator<AuthorizableArgument, R>(wrappee) {

    override fun handle(args: AuthorizableArgument): R {
        if (this.authorizer.authorize(args)) {
            return this.wrappee.handle(args)
        }
        throw AccessDenyException(args)
    }

}