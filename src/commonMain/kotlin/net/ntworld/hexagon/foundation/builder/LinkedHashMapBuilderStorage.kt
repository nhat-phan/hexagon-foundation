package net.ntworld.hexagon.foundation.builder

class LinkedHashMapBuilderStorage : BuilderStorage {
    private val data = mutableMapOf<String, Any?>()

    override fun containsKey(key: String): Boolean = data.containsKey(key)

    @Suppress("UNCHECKED_CAST")
    override fun <T> get(key: String): T = data[key] as T

    override fun <T> set(key: String, value: T) {
        data[key] = value
    }

    override fun remove(key: String) {
        data.remove(key)
    }

    override fun clear() = data.clear()
}