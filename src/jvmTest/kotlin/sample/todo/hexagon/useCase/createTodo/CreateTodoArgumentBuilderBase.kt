package sample.todo.hexagon.useCase.createTodo

import net.ntworld.hexagon.foundation.ArgumentBuilderBase
import sample.todo.CreateTodoArgumentBuilder

internal class CreateTodoArgumentBuilderBase : ArgumentBuilderBase(), CreateTodoArgumentBuilder {
    override fun setTask(value: String) {
        this["task"] = value.trim()
    }
}
