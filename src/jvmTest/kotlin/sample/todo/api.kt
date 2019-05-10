package sample.todo

import net.ntworld.hexagon.foundation.PortAsync
import sample.todo.hexagon.useCase.createTodo.CreateTodoPort

class TodoApi(private val spi: TodoServiceProvider) {

    val createTodo: PortAsync<CreateTodoArgumentBuilder, Todo>
        get() = CreateTodoPort(this.spi)

}
