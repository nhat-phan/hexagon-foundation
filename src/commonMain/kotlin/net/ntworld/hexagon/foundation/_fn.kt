package net.ntworld.hexagon.foundation

import net.ntworld.hexagon.foundation.builder.convertTo
import net.ntworld.hexagon.foundation.internal.*
import net.ntworld.hexagon.foundation.internal.ArgumentDataImpl
import net.ntworld.hexagon.foundation.internal.MultiTenancyArgumentDataImpl
import net.ntworld.hexagon.foundation.internal.PortAsyncImpl
import net.ntworld.hexagon.foundation.internal.PortImpl
import net.ntworld.hexagon.foundation.internal.UserArgumentDataImpl
import net.ntworld.hexagon.foundation.internal.ArgumentValidators
import net.ntworld.kotlin.validator.assert

fun <A : Argument, B : ArgumentBuilder, R> makePort(
    builder: B,
    factory: ArgumentFactory<B, A>,
    handler: ArgumentHandler<A, R>
): Port<B, R> = PortImpl(builder, null, factory, handler)

fun <A : Argument, B : ArgumentBuilder, R> makePort(
    builder: B,
    factory: ArgumentFactory<B, A>,
    handlerFn: (argument: A) -> ArgumentHandler<A, R>
): Port<B, R> = PortImpl(builder, null, factory, handlerFn)

fun <A : Argument, B : ArgumentBuilder, R> makePort(
    builder: B,
    validator: ArgumentValidator<B>,
    factory: ArgumentFactory<B, A>,
    handler: ArgumentHandler<A, R>
): Port<B, R> = PortImpl(builder, validator, factory, handler)

fun <A : Argument, B : ArgumentBuilder, R> makePort(
    builder: B,
    validator: ArgumentValidator<B>,
    factory: ArgumentFactory<B, A>,
    handlerFn: (argument: A) -> ArgumentHandler<A, R>
): Port<B, R> = PortImpl(builder, validator, factory, handlerFn)

fun <A : Argument, B : ArgumentBuilder, R> makePortAsync(
    builder: B,
    factory: ArgumentFactory<B, A>,
    handler: ArgumentHandlerAsync<A, R>
): PortAsync<B, R> = PortAsyncImpl(builder, null, factory, handler)

fun <A : Argument, B : ArgumentBuilder, R> makePortAsync(
    builder: B,
    factory: ArgumentFactory<B, A>,
    handlerFn: (argument: A) -> ArgumentHandlerAsync<A, R>
): PortAsync<B, R> = PortAsyncImpl(builder, null, factory, handlerFn)

fun <A : Argument, B : ArgumentBuilder, R> makePortAsync(
    builder: B,
    validator: ArgumentValidator<B>,
    factory: ArgumentFactory<B, A>,
    handler: ArgumentHandlerAsync<A, R>
): PortAsync<B, R> = PortAsyncImpl(builder, validator, factory, handler)

fun <A : Argument, B : ArgumentBuilder, R> makePortAsync(
    builder: B,
    validator: ArgumentValidator<B>,
    factory: ArgumentFactory<B, A>,
    handlerFn: (argument: A) -> ArgumentHandlerAsync<A, R>
): PortAsync<B, R> = PortAsyncImpl(builder, validator, factory, handlerFn)

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

fun <A : Argument, AB : ArgumentBuilder> AB.makeArgument(factory: AB.(ArgumentData) -> A): A {
    return factory.invoke(this,
        this.assert {
            extend(ArgumentValidators.default)
        } convertTo { ArgumentDataImpl(it) }
    )
}

fun <A : UserArgument, AB : ArgumentBuilder> AB.makeUserArgument(factory: AB.(UserArgumentData) -> A): A {
    return factory.invoke(
        this,
        this.assert {
            extend(ArgumentValidators.default)
            extend(ArgumentValidators.user)
        } convertTo { UserArgumentDataImpl(it) }
    )
}

fun <A : MultiTenancyArgument, AB : ArgumentBuilder> AB.makeMultiTenancyArgument(factory: AB.(MultiTenancyArgumentData) -> A): A {
    return factory.invoke(
        this,
        this.assert {
            extend(ArgumentValidators.default)
            extend(ArgumentValidators.multiTenancy)
        } convertTo { MultiTenancyArgumentDataImpl(it) }
    )
}

fun <A : MultiTenancyUserArgument, AB : ArgumentBuilder> AB.makeMultiTenancyUserArgument(factory: AB.(MultiTenancyUserArgumentData) -> A): A {
    return factory.invoke(
        this,
        this.assert {
            extend(ArgumentValidators.default)
            extend(ArgumentValidators.multiTenancy)
            extend(ArgumentValidators.user)
        } convertTo { MultiTenancyUserArgumentDataImpl(it) }
    )
}