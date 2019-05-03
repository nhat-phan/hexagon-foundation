package net.ntworld.hexagon.foundation.mock.internal

import net.ntworld.hexagon.foundation.mock.InvokeData
import net.ntworld.hexagon.foundation.mock.ParameterList
import kotlin.reflect.KFunction

class MockedFunction<R>(func: KFunction<R>, private val params: List<Any>) {
    val name: String = func.name

    private var invokeOrdinal: Int = 0
    private var hasResult: Boolean = false
    private var result: Any? = null
    private var callFake1: ((ParameterList) -> R)? = null
    private var callFake2: ((ParameterList, InvokeData) -> R)? = null

    fun reset() {
        this.invokeOrdinal = 0
        this.hasResult = false
        this.result = null
        this.callFake1 = null
        this.callFake2 = null
    }

    fun invoke(): R {
        val ordinal = invokeOrdinal + 1
        invokeOrdinal++

        if (null !== callFake2) {
            return callFake2!!.invoke(ParameterList(params), InvokeData(ordinal))
        }

        if (null !== callFake1) {
            return callFake1!!.invoke(ParameterList(params))
        }

        if (hasResult) {
            @Suppress("UNCHECKED_CAST")
            return result as R
        }

        throw Exception("Could not invoke a mock function, please use mock(...) to set a result or callFake first")
    }

    fun setResult(result: R) {
        this.hasResult = true
        this.result = result
    }

    fun setCallFake(callFake: (ParameterList) -> R) {
        this.callFake1 = callFake
    }

    fun setCallFake(callFake: (ParameterList, InvokeData) -> R) {
        this.callFake2 = callFake
    }
}