package net.ntworld.hexagon.foundation.abac

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import net.ntworld.hexagon.foundation.Argument
import net.ntworld.hexagon.foundation.HandlerAsync
import net.ntworld.hexagon.foundation.HandlerDecoratorAsyncBase
import net.ntworld.hexagon.foundation.abac.internal.AuthorizationDataBuilderImpl
import net.ntworld.hexagon.foundation.exception.AccessDenyException

class AuthorizationDecoratorAsync<in A : Argument, out R>(
    handler: HandlerAsync<A, R>,
    private val authorizer: AuthorizerAsync,
    private val directors: List<AuthorizationDataDirectorAsync>
) : HandlerDecoratorAsyncBase<A, R>(handler) {

    override fun handleAsync(argument: A) = GlobalScope.async {
        val data = buildAuthorizationData(argument)

        val hasAccess: Boolean = authorizer.authorizeAsync(data).await()
        if (!hasAccess) {
            throw AccessDenyException(argument, data)
        }

        super.handleAsync(argument).await()
    }

    private suspend fun buildAuthorizationData(argument: A): AuthorizationData {
        val builder = AuthorizationDataBuilderImpl().copyFrom(argument)
        for (director in this.directors) {
            director.constructAuthorizationDataAsync(builder, argument)
        }
        return builder.build()
    }

}
