package net.ntworld.hexagon.foundation

class Event<T> {
    private val handlers = mutableListOf<(T) -> Unit>()

    fun clear() {
        handlers.clear()
    }

    infix fun on(handler: (T) -> Unit) {
        handlers += handler
    }

    fun emit(event: T) {
        for (subscriber in handlers) {
            subscriber(event)
        }
    }
}

