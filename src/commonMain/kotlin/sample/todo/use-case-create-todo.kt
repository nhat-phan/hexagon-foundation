package sample.todo

import net.ntworld.hexagon.foundation.Argument
import net.ntworld.hexagon.foundation.ArgumentBuilder

interface CreateTodoArgument : Argument {
    val task: String
}

interface CreateTodoArgumentBuilder: ArgumentBuilder {
    fun setTask(value: String)
}
