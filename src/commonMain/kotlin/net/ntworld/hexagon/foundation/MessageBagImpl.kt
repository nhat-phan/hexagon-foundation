package net.ntworld.hexagon.foundation

internal class MessageBagImpl : MessageBag {
    private val messages: MutableMap<String, MutableSet<String>> = mutableMapOf<String, MutableSet<String>>()

    override fun clear(): MessageBagImpl {
        this.messages.clear()
        return this
    }

    override fun keys(): Set<String> {
        return this.messages.keys
    }

    override fun has(key: String): Boolean {
        return this.messages.contains(key)
    }

    override fun get(key: String): Set<String> {
        val result = this.messages.get(key)
        return result ?: setOf()
    }

    override fun add(key: String, message: String): MessageBagImpl {
        val bag = this.messages.get(key)
        if (bag === null) {
            val newBag = mutableSetOf(message)
            this.messages.set(key, newBag)
            return this
        }

        bag.add(message)
        return this
    }

    override fun remove(key: String, message: String): MessageBagImpl {
        val bag = this.messages.get(key)
        if (bag === null) {
            return this
        }

        bag.remove(message)
        if (bag.isEmpty()) {
            this.messages.remove(key)
        }
        return this
    }

    override fun toMap(): Map<String, Collection<String>> {
        return this.messages.toMap()
    }

    override fun isEmpty(): Boolean {
        return this.messages.isEmpty()
    }

    override fun isNotEmpty(): Boolean {
        return this.messages.isNotEmpty()
    }
}