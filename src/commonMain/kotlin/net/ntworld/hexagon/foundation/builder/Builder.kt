package net.ntworld.hexagon.foundation.builder

interface Builder : BuilderStorage {
    val builderStorage: BuilderStorage

    override fun clear() = builderStorage.clear()

    override fun containsKey(key: String): Boolean = builderStorage.containsKey(key)

    override fun <T> get(key: String): T = builderStorage.get(key)

    override fun <T> set(key: String, value: T) = builderStorage.set(key, value)
}