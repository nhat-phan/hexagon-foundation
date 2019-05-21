package net.ntworld.hexagon.foundation.mocking.internal

import net.ntworld.hexagon.foundation.mocking.InvokeData
import net.ntworld.hexagon.foundation.mocking.ParameterList
import kotlin.reflect.KFunction

internal class MockedFunction<R>(private val func: KFunction<R>) {
    private var hasResult: Boolean = false
    private var result: Any? = null
    private var callFake1: ((ParameterList) -> R)? = null
    private var callFake2: ((ParameterList, InvokeData) -> R)? = null

    private var calledAtLeast: Int = -1
    private var calledCount: Int = -1
    private var calledWith1: ((ParameterList) -> Boolean)? = null
    private var calledWith2: ((ParameterList, InvokeData) -> Boolean)? = null

    private val calls: FunctionCalls = FunctionCalls()

    fun reset() {
        this.hasResult = false
        this.result = null
        this.callFake1 = null
        this.callFake2 = null

        this.calledCount = -1
        this.calledAtLeast = -1
        this.calledWith1 = null
        this.calledWith2 = null

        this.calls.reset()
    }

    fun verify() {
        if (calledCount != -1 && calledCount != calls.count()) {
            throw Exception("Expect function ${getKeyedName(func)} called $calledCount time(s) but it actually called ${calls.count()} time(s).")
        }

        if (calledAtLeast != -1 && calledAtLeast < calls.count()) {
            throw Exception("Expect function ${getKeyedName(func)} called at least $calledAtLeast time(s) but it actually called ${calls.count()} time(s).")
        }

        if (null !== calledWith2 && !calls.verify(calledWith2!!)) {
            throw Exception("Expect function ${getKeyedName(func)} called with params is failed.")
        }

        if (null !== calledWith1 && !calls.verify(calledWith1!!)) {
            throw Exception("Expect function ${getKeyedName(func)} called with params is failed.")
        }

        this.reset()
    }

    fun invoke(params: List<Any>): R {
        if (null !== callFake2) {
            return calls.callFake(params, callFake2!!)
        }

        if (null !== callFake1) {
            return calls.callFake(params, callFake1!!)
        }

        if (hasResult) {
            @Suppress("UNCHECKED_CAST")
            return calls.returnResult(params, result as R)
        }

        throw Exception("Could not invoke a mocking function, please use mock(...) to set a result or callFake first")
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

    fun setCalledAtLeast(count: Int) {
        this.calledAtLeast = count
    }

    fun setCalledCount(count: Int) {
        this.calledCount = count
    }

    fun setCalledWith1(block: (ParameterList) -> Boolean) {
        this.calledWith1 = block
    }

    fun setCalledWith2(block: (ParameterList, InvokeData) -> Boolean) {
        this.calledWith2 = block
    }

    companion object {
        fun getKeyedName(func: KFunction<*>): String {
            return func.name
        }
    }
}