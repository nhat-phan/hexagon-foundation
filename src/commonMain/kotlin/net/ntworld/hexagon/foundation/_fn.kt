package net.ntworld.hexagon.foundation

import net.ntworld.hexagon.foundation.internal.PortAsyncImpl

//fun <A : Argument, B : ArgumentBuilder, R> makePort(
//    builder: B,
//    factory: ArgumentFactory<B, A>,
//    handler: Handler<A, R>
//): Port<B, R> = PortImpl(builder, factory, handler)
//
//fun <A : Argument, B : ArgumentBuilder, R> makePort(
//    builder: B,
//    factory: ArgumentFactory<B, A>,
//    handlerFn: (argument: A) -> Handler<A, R>
//): Port<B, R> = PortImpl(builder, factory, handlerFn)

fun <A : Argument, B : ArgumentBuilder, R> makePortAsync(
    builder: B,
    factory: ArgumentFactory<B, A>,
    handler: HandlerAsync<A, R>
): PortAsync<B, R> = PortAsyncImpl(builder, factory, handler)

fun <A : Argument, B : ArgumentBuilder, R> makePortAsync(
    builder: B,
    factory: ArgumentFactory<B, A>,
    handlerFn: (argument: A) -> HandlerAsync<A, R>
): PortAsync<B, R> = PortAsyncImpl(builder, factory, handlerFn)

operator fun <T : ArgumentBuilder> ArgumentBuildDirector<T>.plus(buildDirector: ArgumentBuildDirector<T>): ArgumentBuildDirector<T> {
    if (buildDirector is ArgumentBuildDirectorCollection) {
        buildDirector.add(this)
        return buildDirector
    }

    val collection = ArgumentBuildDirectorCollection(this)
    collection.add(buildDirector)
    return collection
}

operator fun <T : ArgumentBuilder> ArgumentValidator<T>.plus(validator: ArgumentValidator<T>): ArgumentValidator<T> {
    if (validator is ArgumentValidatorCollection) {
        validator.add(this)
        return validator
    }

    val collection = ArgumentValidatorCollection(this)
    collection.add(validator)
    return collection
}