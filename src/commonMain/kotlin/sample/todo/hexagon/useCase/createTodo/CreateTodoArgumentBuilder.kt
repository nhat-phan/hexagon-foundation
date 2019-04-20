package sample.todo.hexagon.useCase.createTodo

import net.ntworld.hexagon.foundation.ArgumentBuilderBase
import sample.todo.CreateTodoArgumentBuilder

internal class CreateTodoArgumentBuilder : ArgumentBuilderBase(), CreateTodoArgumentBuilder {
    override fun setTask(value: String) {
        this.set("task", value.trim())
    }
}
