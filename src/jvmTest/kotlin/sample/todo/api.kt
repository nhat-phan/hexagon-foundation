package sample.todo

import net.ntworld.hexagon.foundation.PortAsync
import sample.todo.hexagon.useCase.createTodo.CreateTodoPort

class TodoApi(private val spi: TodoServiceProvider) {

    fun createTodoPort(): PortAsync<CreateTodoArgument, CreateTodoArgumentBuilder, Todo> {
        return CreateTodoPort(this.spi)
    }

}
