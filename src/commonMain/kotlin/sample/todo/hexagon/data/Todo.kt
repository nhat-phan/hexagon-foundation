package sample.todo.hexagon.data

import sample.todo.Todo

data class Todo(
    override val id: String,
    override val task: String
) : Todo