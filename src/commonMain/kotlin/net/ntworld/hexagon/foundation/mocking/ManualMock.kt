package net.ntworld.hexagon.foundation.mocking

import net.ntworld.hexagon.foundation.mocking.internal.MockedFunction
import kotlin.reflect.KFunction

open class ManualMock {
    private val data: MutableMap<String, MockedFunction<*>> = hashMapOf()

    internal fun <R> getMockedFunction(func: KFunction<R>): MockedFunction<R> {
        val name = MockedFunction.getKeyedName(func)
        if (data.contains(name)) {
            @Suppress("UNCHECKED_CAST")
            return data[name] as MockedFunction<R>
        }
        throw Exception("Please use .mockFunction() in the function you want to be mocked")
    }

    protected fun <R> mockFunction(func: KFunction<R>, vararg params: Any): R {
        val name = MockedFunction.getKeyedName(func)
        if (data.contains(name)) {
            throw Exception("Function $name already mocked, please use reset(mocking) before using the mocking again")
        }

        val mockedFunction = MockedFunction(func, params.toList())
        data[name] = mockedFunction
        return mockedFunction.invoke()
    }
}