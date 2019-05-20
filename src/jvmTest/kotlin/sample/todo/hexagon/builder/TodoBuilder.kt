package sample.todo.hexagon.builder

import net.ntworld.hexagon.foundation.ArgumentBuilder
import net.ntworld.hexagon.foundation.builder.LinkedHashMapBuilderStorage
import net.ntworld.hexagon.foundation.builder.string
import sample.todo.CreateTodoArgumentBuilder

internal class TodoBuilder : ArgumentBuilder, CreateTodoArgumentBuilder {
    override val builderStorage = LinkedHashMapBuilderStorage()

    override var task: String by string()
}
