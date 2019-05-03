package net.ntworld.hexagon.foundation.mock

import net.ntworld.hexagon.foundation.mock.internal.MockedFunction
import kotlin.reflect.KFunction

open class ManualMock {
    private val data: MutableMap<String, MockedFunction<*>> = hashMapOf()

    protected fun <R> mockFunction(func: KFunction<R>, vararg params: Any): R {
        val mockedFunction = MockedFunction(func, params.toList())

        if (data.contains(mockedFunction.name)) {
            throw Exception("Function ${mockedFunction.name} already mocked, please use reset(mock) before using the mock again")
        }

        data[mockedFunction.name] = mockedFunction
        return mockedFunction.invoke()
    }
}