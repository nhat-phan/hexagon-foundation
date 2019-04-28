package net.ntworld.hexagon.foundation.abac

import kotlinx.coroutines.Deferred
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

    override suspend fun handleAsync(argument: A): Deferred<R> {
        val data = buildAuthorizationData(argument)

        val hasAccess: Boolean = authorizer.authorizeAsync(data).await()
        if (!hasAccess) {
            throw AccessDenyException(argument, data)
        }

        return super.handleAsync(argument)
    }

    private suspend fun buildAuthorizationData(argument: A): AuthorizationData {
        val builder = AuthorizationDataBuilderImpl().copyFrom(argument)
        for (director in this.directors) {
            director.constructAuthorizationDataAsync(builder, argument)
        }
        return builder.build()
    }

}
