package sample.todo

import net.ntworld.hexagon.foundation.ArgumentBuilder

interface CreateTodoArgumentBuilder: ArgumentBuilder {
    fun setTask(value: String)
}
