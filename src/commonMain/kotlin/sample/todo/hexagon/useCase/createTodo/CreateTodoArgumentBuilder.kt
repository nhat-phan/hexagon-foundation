package sample.todo.hexagon.useCase.createTodo

import net.ntworld.hexagon.foundation.ArgumentBuilderBase
import sample.todo.CreateTodoArgumentBuilder

internal class CreateTodoArgumentBuilder : ArgumentBuilderBase(), CreateTodoArgumentBuilder {
    internal var task: String = ""

    override fun setTask(value: String) {
        this.task = value
    }

    override fun resetBuilder() {
        this.task = ""
    }
}
