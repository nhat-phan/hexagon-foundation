package sample.todo

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import net.ntworld.hexagon.foundation.ArgumentBuilder
import net.ntworld.hexagon.foundation.ArgumentBuildDirector
import sample.todo.hexagon.entity.Todo
import kotlin.system.measureTimeMillis
import kotlin.test.Test


class SharedBuildDirector : ArgumentBuildDirector<ArgumentBuilder> {
    override fun constructArgument(builder: ArgumentBuilder) {
        builder.setUniqueId("test")
        builder.setCurrentUserId("test")
        builder.setContextEnvironment("test", "test")
        builder.setContextDatetime("now")
        builder.setContextIpAddress("now")
    }
}

class FakeTodoRepository : TodoRepository {
    override fun createAsync(task: String) = GlobalScope.async {
        delay(1000)

        Todo("1", task)
    }
}

class FakeTodoServiceProvider : TodoServiceProvider {
    override val todoRepository: TodoRepository
        get() = FakeTodoRepository()
}

class ApiTest {
    @Test
    fun testCreate() = runBlocking {
        val spi = FakeTodoServiceProvider()
        val api = TodoApi(spi)

        val time = measureTimeMillis {
            val one = async {
                val result = api.createTodo use SharedBuildDirector() with {
                    setTask("one")
                }
                result.await()
            }

            val two = async {
                val result = api.createTodo use SharedBuildDirector() with {
                    setTask("two")
                }
                result.await()
            }

            val three = async {
                val result = api.createTodo use SharedBuildDirector() with {
                    setTask("three")
                }
                result.await()
            }

            println(one.await().task + " - " + two.await().task + " - " + three.await().task)
        }

        println("Completed in $time ms")
    }
}