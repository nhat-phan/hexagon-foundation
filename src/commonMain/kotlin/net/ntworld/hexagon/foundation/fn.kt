package net.ntworld.hexagon.foundation

import net.ntworld.hexagon.foundation.internal.ArgumentContextImpl
import net.ntworld.hexagon.foundation.internal.ArgumentImpl
import net.ntworld.hexagon.foundation.internal.PortAsyncImpl
import net.ntworld.hexagon.foundation.internal.PortImpl

fun argumentBuilderDataOf(data: Map<String, Any>): ArgumentBuilderData {
    return ArgumentBuilderDataBase(data)
}

fun makeArgumentContext(environmentType: String, environmentId: String, datetime: String): ArgumentContext {
    return ArgumentContextImpl(environmentType, environmentId, datetime)
}

fun makeArgument(uniqueId: String, context: ArgumentContext): Argument {
    return ArgumentImpl(uniqueId, context)
}

fun makeArgument(
    uniqueId: String,
    environmentType: String,
    environmentId: String,
    datetime: String
): Argument {
    return ArgumentImpl(uniqueId, makeArgumentContext(environmentType, environmentId, datetime))
}

fun <A : Argument, T, R> portOf(
    builder: T,
    handler: Handler<A, R>
): Port<A, T, R> where T : ArgumentBuilder, T : ArgumentFactory<T, A> = PortImpl(builder, builder, handler)

fun <A : Argument, T, R> portOf(
    builder: T,
    handlerFn: (argument: A) -> Handler<A, R>
): Port<A, T, R> where T : ArgumentBuilder, T : ArgumentFactory<T, A> = PortImpl(builder, builder, handlerFn)

fun <A : Argument, B : ArgumentBuilder, R> portOf(
    builder: B,
    factory: ArgumentFactory<B, A>,
    handler: Handler<A, R>
): Port<A, B, R> = PortImpl(builder, factory, handler)

fun <A : Argument, B : ArgumentBuilder, R> portOf(
    builder: B,
    factory: ArgumentFactory<B, A>,
    handlerFn: (argument: A) -> Handler<A, R>
): Port<A, B, R> = PortImpl(builder, factory, handlerFn)

fun <A : Argument, T, R> portOf(
    builder: T,
    handler: HandlerAsync<A, R>
): PortAsync<A, T, R> where T : ArgumentBuilder, T : ArgumentFactory<T, A> = PortAsyncImpl(builder, builder, handler)

fun <A : Argument, T, R> portOf(
    builder: T,
    handlerFn: (argument: A) -> HandlerAsync<A, R>
): PortAsync<A, T, R> where T : ArgumentBuilder, T : ArgumentFactory<T, A> = PortAsyncImpl(builder, builder, handlerFn)

fun <A : Argument, B : ArgumentBuilder, R> portOf(
    builder: B,
    factory: ArgumentFactory<B, A>,
    handler: HandlerAsync<A, R>
): PortAsync<A, B, R> = PortAsyncImpl(builder, factory, handler)

fun <A : Argument, B : ArgumentBuilder, R> portOf(
    builder: B,
    factory: ArgumentFactory<B, A>,
    handlerFn: (argument: A) -> HandlerAsync<A, R>
): PortAsync<A, B, R> = PortAsyncImpl(builder, factory, handlerFn)