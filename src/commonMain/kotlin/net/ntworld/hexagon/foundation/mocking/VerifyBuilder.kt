package net.ntworld.hexagon.foundation.mocking

import kotlin.reflect.KFunction

class VerifyBuilder(private val instance: ManualMock) {
    infix fun <R> KFunction<R>.invoke(block: (params: ParameterList) -> R) {

    }
}