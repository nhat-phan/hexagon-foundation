package net.ntworld.hexagon.foundation.abac

import net.ntworld.hexagon.foundation.Argument
import net.ntworld.hexagon.foundation.Handler
import net.ntworld.hexagon.foundation.HandlerDecoratorBase
import net.ntworld.hexagon.foundation.abac.internal.AuthorizationDataBuilderBaseImpl
import net.ntworld.hexagon.foundation.exception.AccessDenyException

class AuthorizationDecorator<out R>(
    handler: Handler<Argument, R>,
    private val authorizer: Authorizer,
    private val director: AuthorizationDataDirector,
    private vararg val otherDirectors: AuthorizationDataDirector
) : HandlerDecoratorBase<Argument, R>(handler) {

    override fun handle(argument: Argument): R {
        val data = buildAuthorizationData(argument)

        val hasAccess: Boolean = authorizer.authorize(data)
        if (!hasAccess) {
            throw AccessDenyException(argument, data)
        }

        return super.handle(argument)
    }

    private fun buildAuthorizationData(argument: Argument): AuthorizationData {
        val builder = AuthorizationDataBuilderBaseImpl().copyFrom(argument)
        val directors = this.getDirectors()
        for (director in directors) {
            director.constructAuthorizationData(builder, argument)
        }
        return builder.build()
    }

    private fun getDirectors(): Collection<AuthorizationDataDirector> {
        if (otherDirectors.isEmpty()) {
            return listOf(director)
        }
        return listOf(director) + otherDirectors
    }

}
