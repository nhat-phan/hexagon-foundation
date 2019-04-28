package sample.todo.hexagon.builder

import net.ntworld.hexagon.foundation.ArgumentBuilderBase
import sample.todo.CreateTodoArgumentBuilder

internal class TodoBuilder : ArgumentBuilderBase(), CreateTodoArgumentBuilder {
    override fun setTask(value: String) {
        this["task"] = value.trim()
    }
}
