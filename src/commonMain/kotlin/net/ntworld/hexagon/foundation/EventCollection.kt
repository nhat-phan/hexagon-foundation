package net.ntworld.hexagon.foundation

class EventCollection<T> {
    private val events = mutableMapOf<String, Event<T>>()

    private fun getEvent(name: String): Event<T> {
        val item = events.get(name)
        if (null === item) {
            val event = Event<T>()
            events[name] = event
            return event
        }
        return item
    }

    fun on(name: String, handler: (T) -> Unit) {
        this.getEvent(name).on(handler)
    }

    fun clearAll() {
        events.clear()
    }

    fun clear(name: String) {
        events.remove(name)
    }

    fun emit(name: String, data: T) {
        this.getEvent(name).emit(data)
    }
}