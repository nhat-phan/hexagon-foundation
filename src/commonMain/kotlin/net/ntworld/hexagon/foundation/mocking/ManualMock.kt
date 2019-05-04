package net.ntworld.hexagon.foundation.mocking

import net.ntworld.hexagon.foundation.mocking.internal.MockedFunction
import kotlin.reflect.KFunction

open class ManualMock {
    private val data: MutableMap<String, MockedFunction<*>> = hashMapOf()

    internal fun verifyAll() {
        for (mockedFunctions in data.values) {
            mockedFunctions.verify()
        }
    }

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
        if (!data.contains(name)) {
            data[name] = MockedFunction(func)
        }

        @Suppress("UNCHECKED_CAST")
        return (data[name] as MockedFunction<R>).invoke(params.toList())
    }
}