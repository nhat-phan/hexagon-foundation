package sample.todo

interface TodoRepository {
    fun create(task: String): Todo

    fun update(id: String, task: String): Todo

    fun delete(id: String): Boolean

    fun findById(id: String): Todo?

    fun getAll(): Collection<Todo>
}

interface TodoServiceProvider {
    val todoRepository: TodoRepository
}