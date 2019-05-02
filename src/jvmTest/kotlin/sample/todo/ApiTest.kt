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
        val port = api.createTodoPort()

        val time = measureTimeMillis {
            val one = async {
                port.use(SharedBuildDirector())
                    .with { it.setTask("one") }
                    .executeAsync()
                    .await()
            }

            val two = async {
                port.use(SharedBuildDirector())
                    .with { it.setTask("two") }
                    .executeAsync()
                    .await()
            }

            val three = async {
                port.use(SharedBuildDirector())
                    .with { it.setTask("three") }
                    .executeAsync()
                    .await()
            }

            println(one.await().task + " - " + two.await().task + " - " + three.await().task)
        }

        println("Completed in $time ms")
    }
}