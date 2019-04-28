package sample.todo.hexagon.entity

import sample.todo.Todo

data class Todo(
    override val id: String,
    override val task: String
) : Todo