package sample.todo

import net.ntworld.hexagon.foundation.ArgumentBuilder

interface CreateTodoArgumentBuilder: ArgumentBuilder {
    var task: String
}
