package net.ntworld.hexagon.foundation


fun <A : Argument, T, R> portOf(
    builder: T,
    handler: Handler<A, R>
): Port<A, T, R> where T : ArgumentBuilder, T : ArgumentFactory<T, A> {
    return PortImpl(builder, builder, handler)
}

fun <A : Argument, T, R> portOf(
    builder: T,
    handlerFn: (argument: A) -> Handler<A, R>
): Port<A, T, R> where T : ArgumentBuilder, T : ArgumentFactory<T, A> {
    return PortImpl(builder, builder, handlerFn)
}

fun <A : Argument, B : ArgumentBuilder, R> portOf(
    builder: B,
    factory: ArgumentFactory<B, A>,
    handler: Handler<A, R>
): Port<A, B, R> {
    return PortImpl(builder, factory, handler)
}

fun <A : Argument, B : ArgumentBuilder, R> portOf(
    builder: B,
    factory: ArgumentFactory<B, A>,
    handlerFn: (argument: A) -> Handler<A, R>
): Port<A, B, R> {
    return PortImpl(builder, factory, handlerFn)
}