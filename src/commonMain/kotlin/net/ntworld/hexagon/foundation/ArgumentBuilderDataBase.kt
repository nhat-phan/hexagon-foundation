package net.ntworld.hexagon.foundation


open class ArgumentBuilderDataBase(private val data: Map<String, Any>) : ArgumentBuilderData, Map<String, Any> by data {
    override fun <T> getValue(key: String): T {
        return this.data[key] as T
    }

    override fun <T> getValue(key: String, defaultValue: T): T {
        val value = this.data[key]
        if (null === value) {
            return defaultValue
        }
        return value as T
    }

    override fun ifNot(key: String, value: Boolean, lambda: (value: Any?) -> Unit): Boolean {
        if (!value) {
            lambda(this.data[key])
            return true
        }
        return false
    }

    override fun isString(key: String): Boolean {
        return this.data[key] is String
    }

    override fun isStringAndNotBlank(key: String): Boolean {
        val value = this.data[key]
        return value is String && value.isNotBlank()
    }

    override fun isInteger(key: String): Boolean {
        return this.data[key] is Int
    }

    override fun isPositiveInteger(key: String): Boolean {
        val value = this.data[key]
        return value is Int && value > 0
    }
}
