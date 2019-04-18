package net.ntworld.hexagon.foundation

interface MessageBag {
    fun clear(): MessageBag

    fun keys(): Set<String>

    fun has(key: String): Boolean

    fun get(key: String): Set<String>

    fun add(key: String, message: String): MessageBag

    fun remove(key: String, message: String): MessageBag

    fun toMap(): Map<String, Collection<String>>

    fun isEmpty(): Boolean

    fun isNotEmpty(): Boolean
}