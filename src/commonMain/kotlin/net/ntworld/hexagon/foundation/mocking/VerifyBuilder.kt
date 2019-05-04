package net.ntworld.hexagon.foundation.mocking

import kotlin.reflect.KFunction

class VerifyBuilder(private val instance: ManualMock) {
    infix fun <R> KFunction<R>.invoke(block: VerifyFunctionBuilder<R>.() -> Unit) {
        VerifyFunctionBuilder(instance, this).apply(block)
    }

    fun verify() {
        instance.verifyAll()
    }
}