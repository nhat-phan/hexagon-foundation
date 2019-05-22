package net.ntworld.hexagon.foundation

import net.ntworld.hexagon.foundation.builder.convertTo
import net.ntworld.hexagon.foundation.internal.*
import net.ntworld.hexagon.foundation.internal.ArgumentDataImpl
import net.ntworld.hexagon.foundation.internal.MultiTenancyArgumentDataImpl
import net.ntworld.hexagon.foundation.internal.PortAsyncImpl
import net.ntworld.hexagon.foundation.internal.PortImpl
import net.ntworld.hexagon.foundation.internal.UserArgumentDataImpl
import net.ntworld.hexagon.foundation.old_validation.assert
import net.ntworld.hexagon.foundation.old_validation.required

fun <A : Argument, B : ArgumentBuilder, R> makePort(
    builder: B,
    factory: ArgumentFactory<B, A>,
    handler: Handler<A, R>
): Port<B, R> = PortImpl(builder, null, factory, handler)

fun <A : Argument, B : ArgumentBuilder, R> makePort(
    builder: B,
    factory: ArgumentFactory<B, A>,
    handlerFn: (argument: A) -> Handler<A, R>
): Port<B, R> = PortImpl(builder, null, factory, handlerFn)

fun <A : Argument, B : ArgumentBuilder, R> makePort(
    builder: B,
    validator: ArgumentValidator<B>,
    factory: ArgumentFactory<B, A>,
    handler: Handler<A, R>
): Port<B, R> = PortImpl(builder, validator, factory, handler)

fun <A : Argument, B : ArgumentBuilder, R> makePort(
    builder: B,
    validator: ArgumentValidator<B>,
    factory: ArgumentFactory<B, A>,
    handlerFn: (argument: A) -> Handler<A, R>
): Port<B, R> = PortImpl(builder, validator, factory, handlerFn)

fun <A : Argument, B : ArgumentBuilder, R> makePortAsync(
    builder: B,
    factory: ArgumentFactory<B, A>,
    handler: HandlerAsync<A, R>
): PortAsync<B, R> = PortAsyncImpl(builder, null, factory, handler)

fun <A : Argument, B : ArgumentBuilder, R> makePortAsync(
    builder: B,
    factory: ArgumentFactory<B, A>,
    handlerFn: (argument: A) -> HandlerAsync<A, R>
): PortAsync<B, R> = PortAsyncImpl(builder, null, factory, handlerFn)

fun <A : Argument, B : ArgumentBuilder, R> makePortAsync(
    builder: B,
    validator: ArgumentValidator<B>,
    factory: ArgumentFactory<B, A>,
    handler: HandlerAsync<A, R>
): PortAsync<B, R> = PortAsyncImpl(builder, validator, factory, handler)

fun <A : Argument, B : ArgumentBuilder, R> makePortAsync(
    builder: B,
    validator: ArgumentValidator<B>,
    factory: ArgumentFactory<B, A>,
    handlerFn: (argument: A) -> HandlerAsync<A, R>
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

fun <A : Argument, AB : ArgumentBuilder> AB.makeArgument(factory: (AB, ArgumentData) -> A): A {
    return factory(
        this,
        this.assert {
            ::uniqueId always required
            ::contextEnvironmentType always required
            ::contextEnvironmentId always required
            ::contextDatetime always required
            ::contextIpAddress always required
        }
            convertTo { ArgumentDataImpl(it) }
    )
}

fun <A : UserArgument, AB : ArgumentBuilder> AB.makeUserArgument(factory: (AB, UserArgumentData) -> A): A {
    return factory(
        this,
        this.assert {
            ::uniqueId always required
            ::contextEnvironmentType always required
            ::contextEnvironmentId always required
            ::contextDatetime always required
            ::contextIpAddress always required

            ::currentUserId always required
        }
            convertTo { UserArgumentDataImpl(it) }
    )
}

fun <A : MultiTenancyArgument, AB : ArgumentBuilder> AB.makeMultiTenancyArgument(factory: (AB, MultiTenancyArgumentData) -> A): A {
    return factory(
        this,
        this.assert {
            ::uniqueId always required
            ::contextEnvironmentType always required
            ::contextEnvironmentId always required
            ::contextDatetime always required
            ::contextIpAddress always required

            ::currentTenantId always required
        }
            convertTo { MultiTenancyArgumentDataImpl(it) }
    )
}

fun <A : MultiTenancyUserArgument, AB : ArgumentBuilder> AB.makeMultiTenancyUserArgument(factory: (AB, MultiTenancyUserArgumentData) -> A): A {
    return factory(
        this,
        this.assert {
            ::uniqueId always required
            ::contextEnvironmentType always required
            ::contextEnvironmentId always required
            ::contextDatetime always required
            ::contextIpAddress always required

            ::currentTenantId always required
            ::currentUserId always required
        }
            convertTo { MultiTenancyUserArgumentDataImpl(it) }
    )
}