package sample.todo

import net.ntworld.hexagon.foundation.ArgumentBuilder
import net.ntworld.hexagon.foundation.MultiTenancyArgument

interface CreateTodoArgument : MultiTenancyArgument{
    val task: String
}

interface CreateTodoArgumentBuilder: ArgumentBuilder {
    fun setTask(value: String)
}
