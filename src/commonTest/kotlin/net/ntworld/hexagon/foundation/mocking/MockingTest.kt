package net.ntworld.hexagon.foundation.mocking

import kotlin.test.Test
import kotlin.test.assertEquals

interface ServiceProvider {
    fun checkUsername(id: String, username: String): Boolean

    fun checkEmail(id: String, email: String): String
}

class ServiceProviderMock : ManualMock(), ServiceProvider {
    override fun checkUsername(id: String, username: String): Boolean {
        return this.mockFunction(this::checkUsername, id, username)
    }

    override fun checkEmail(id: String, email: String): String {
        return this.mockFunction(this::checkEmail, id, email)
    }
}

class MockingTest {
    val serviceProvider: ServiceProviderMock = ServiceProviderMock()

    @Test
    fun testMockWillResult() {
        mock(serviceProvider) {
            ServiceProvider::checkEmail willReturn { "anything" }
        }

        assertEquals("anything", this.serviceProvider.checkEmail("id", "email"))
        reset(serviceProvider)
    }

    @Test
    fun testMockCallFake1() {
        mock(serviceProvider) {
            ServiceProvider::checkEmail callFake { params ->
                val (id, email) = params
                assertEquals("id", id)
                assertEquals("email", email)
                "anything"
            }
        }

        assertEquals("anything", this.serviceProvider.checkEmail("id", "email"))
        reset(serviceProvider)
    }

    @Test
    fun testMockCallFake2() {
        mock(serviceProvider) {
            ServiceProvider::checkEmail callFake { params, invokeData ->
                val (id, email) = params
                assertEquals("id", id)
                assertEquals("email", email)
                "anything-" + invokeData.ordinal
            }
        }

        assertEquals("anything-1", this.serviceProvider.checkEmail("id", "email"))
        assertEquals("anything-2", this.serviceProvider.checkEmail("id", "email"))
        reset(serviceProvider)
    }

    @Test
    fun testVerifyCalled() {
        mock(serviceProvider) {
            ServiceProvider::checkEmail willReturn "anything"
        }

        this.serviceProvider.checkEmail("id", "email")

        verify(serviceProvider) {
            ServiceProvider::checkEmail { called = 1 }
        }
    }

    @Test
    fun testVerifyCalledWith1() {
        mock(serviceProvider) {
            ServiceProvider::checkEmail willReturn "anything"
        }

        this.serviceProvider.checkEmail("id", "email")

        verify(serviceProvider) {
            ServiceProvider::checkEmail {
                with { params ->
                    val (id, email) = params

                    id == "id" && email == "email"
                }
            }
        }
    }

    @Test
    fun testVerifyCalledWith2() {
        mock(serviceProvider) {
            ServiceProvider::checkEmail willReturn "anything"
        }

        this.serviceProvider.checkEmail("id", "email")

        verify(serviceProvider) {
            ServiceProvider::checkEmail {
                with { params, invokeData ->
                    val (id, email) = params

                    invokeData.ordinal == 1 && id == "id" && email == "email"
                }
            }
        }
    }
}