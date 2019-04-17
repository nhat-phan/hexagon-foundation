package sample.todo

import net.ntworld.hexagon.foundation.ArgumentBuilder
import net.ntworld.hexagon.foundation.ArgumentDirector
import net.ntworld.hexagon.foundation.Port
import sample.todo.hexagon.useCase.createTodo.CreateTodoPort

class TodoApi(private val spi: TodoServiceProvider) {

    fun createTodoPort(): Port<CreateTodoArgument, CreateTodoArgumentBuilder, Todo> {
        return CreateTodoPort(this.spi)
    }

}

class SharedDirector : ArgumentDirector<ArgumentBuilder> {
    override fun constructArgument(builder: ArgumentBuilder) {

    }
}

class TodoDirector : ArgumentDirector<CreateTodoArgumentBuilder> {
    override fun constructArgument(builder: CreateTodoArgumentBuilder) {

    }
}

fun main() {
    val todoSpi = "" as TodoServiceProvider
    val todoApi = TodoApi(todoSpi)

    val port = todoApi.createTodoPort()
    port
        .use(SharedDirector())
        .use(TodoDirector())
        .execute()

}