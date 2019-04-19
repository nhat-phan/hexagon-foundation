package sample.todo.hexagon.useCase.createTodo

import net.ntworld.hexagon.foundation.ArgumentContext
import net.ntworld.hexagon.foundation.MultiTenancyArgumentBuilderBase
import sample.todo.CreateTodoArgument
import sample.todo.CreateTodoArgumentBuilder

internal class CreateTodoArgumentBuilder :
    MultiTenancyArgumentBuilderBase<CreateTodoArgument>(),
    CreateTodoArgumentBuilder {
    private var task: String = ""

    override fun setTask(value: String) {
        this.task = value
    }

    override fun build(uniqueId: String, tenantId: String, context: ArgumentContext): CreateTodoArgument {
        return CreateTodoArgument(uniqueId, tenantId, context, this.task)
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