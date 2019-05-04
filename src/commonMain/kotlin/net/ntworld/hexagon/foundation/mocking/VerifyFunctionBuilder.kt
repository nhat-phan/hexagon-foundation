package net.ntworld.hexagon.foundation.mocking

import kotlin.reflect.KFunction

class VerifyFunctionBuilder<R>(private val instance: ManualMock, private val func: KFunction<R>) {
    var called: Int = -1
        set(value: Int) {
            instance.getMockedFunction(func).setCalledCount(value)
        }

    fun with(block: (ParameterList) -> Boolean) {
        instance.getMockedFunction(func).setCalledWith1(block)
    }

    fun with(block: (ParameterList, InvokeData) -> Boolean) {
        instance.getMockedFunction(func).setCalledWith2(block)
    }
}