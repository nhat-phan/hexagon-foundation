package net.ntworld.hexagon.foundation

interface ArgumentBuilder {
    fun reset()

    fun setUniqueId(value: String)

    fun setContextEnvironment(type: String, id: String)

    fun setContextDatetime(value: String)
}