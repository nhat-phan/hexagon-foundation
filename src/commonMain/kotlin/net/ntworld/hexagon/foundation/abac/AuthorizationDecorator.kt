package net.ntworld.hexagon.foundation.abac

import net.ntworld.hexagon.foundation.Argument
import net.ntworld.hexagon.foundation.Handler
import net.ntworld.hexagon.foundation.HandlerDecoratorBase
import net.ntworld.hexagon.foundation.abac.internal.AuthorizationDataBuilderImpl
import net.ntworld.hexagon.foundation.exception.AccessDenyException

class AuthorizationDecorator<in A : Argument, out R>(
    handler: Handler<A, R>,
    private val authorizer: Authorizer,
    private val directors: List<AuthorizationDataBuildDirector>
) : HandlerDecoratorBase<A, R>(handler) {

    override fun handle(argument: A): R {
        val data = buildAuthorizationData(argument)

        val hasAccess: Boolean = authorizer.authorize(data)
        if (!hasAccess) {
            throw AccessDenyException(argument, data)
        }

        return super.handle(argument)
    }

    private fun buildAuthorizationData(argument: A): AuthorizationData {
        val builder = AuthorizationDataBuilderImpl().copyFrom(argument)
        for (director in directors) {
            director.constructAuthorizationData(builder, argument)
        }
        return builder.build()
    }

}
