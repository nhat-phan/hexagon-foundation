package sample.todo.hexagon.useCase.createTodo

import net.ntworld.hexagon.foundation.ArgumentBuilderBase
import net.ntworld.hexagon.foundation.ArgumentContext
import sample.todo.CreateTodoArgument
import sample.todo.CreateTodoArgumentBuilder

internal class CreateTodoArgumentBuilder :
    ArgumentBuilderBase<CreateTodoArgument>(),
    CreateTodoArgumentBuilder {
    private var task: String = ""

    override fun setTask(value: String) {
        this.task = value
    }

    override fun build(uniqueId: String, context: ArgumentContext): CreateTodoArgument {
        return CreateTodoArgument(uniqueId, context, this.task)
    }

    override fun validate(): Boolean {
        if (this.task.isBlank()) {
            this.errors.add("task", "required")
        }
        return this.errors.isEmpty()
    }

    override fun resetBuilder() {
        this.task = ""
    }
}