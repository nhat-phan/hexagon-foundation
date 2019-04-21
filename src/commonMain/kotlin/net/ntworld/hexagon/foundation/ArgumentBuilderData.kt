package net.ntworld.hexagon.foundation

typealias TrueLambda = (value: Any?) -> Unit

interface ArgumentBuilderData : Map<String, Any> {
    val uniqueId: String?
        get() = this.get(BuilderKey.UNIQUE_ID.key) as String?

    val contextEnvironmentType: String?
        get() = this.get(BuilderKey.CONTEXT_ENVIRONMENT_TYPE.key) as String?

    val contextEnvironmentId: String?
        get() = this.get(BuilderKey.CONTEXT_ENVIRONMENT_ID.key) as String?

    val contextDatetime: String?
        get() = this.get(BuilderKey.CONTEXT_DATETIME.key) as String?

    fun <T> getValue(key: String): T

    fun <T> getValue(key: String, defaultValue: T): T

    fun ifNot(key: String, value: Boolean, lambda: TrueLambda): Boolean


    fun isString(key: String): Boolean

    fun isNotString(key: String): Boolean = !this.isString(key)

    fun isNotString(key: String, trueLambda: TrueLambda): Boolean = this.ifNot(key, this.isString(key), trueLambda)


    fun isStringAndNotBlank(key: String): Boolean

    fun isNotStringOrBlank(key: String): Boolean = !this.isStringAndNotBlank(key)

    fun isNotStringOrBlank(key: String, trueLambda: TrueLambda): Boolean =
        this.ifNot(key, this.isStringAndNotBlank(key), trueLambda)

    fun isNotStringOrEmpty(key: String): Boolean = !this.isStringAndNotBlank(key)

    fun isNotStringOrEmpty(key: String, trueLambda: TrueLambda): Boolean =
        this.ifNot(key, this.isStringAndNotBlank(key), trueLambda)


    fun isInteger(key: String): Boolean

    fun isNotInteger(key: String): Boolean = !this.isInteger(key)

    fun isNotInteger(key: String, trueLambda: TrueLambda): Boolean = this.ifNot(key, this.isInteger(key), trueLambda)


    fun isPositiveInteger(key: String): Boolean

    fun isNotPositiveInteger(key: String): Boolean = !this.isPositiveInteger(key)

    fun isNotPositiveInteger(key: String, trueLambda: TrueLambda): Boolean =
        this.ifNot(key, this.isPositiveInteger(key), trueLambda)

}
