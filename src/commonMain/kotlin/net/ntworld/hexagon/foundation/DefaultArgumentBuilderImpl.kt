package net.ntworld.hexagon.foundation

internal class DefaultArgumentBuilderImpl : ArgumentBuilderBase<Argument>() {
    override fun build(uniqueId: String, tenantId: String?, context: ArgumentContext): Argument {
        return makeArgument(uniqueId, tenantId, context)
    }

    override fun validate(): Boolean {
        return true
    }

    override fun resetBuilder() {
    }
}

fun defaultArgumentBuilder(): ArgumentBuilder {
    return DefaultArgumentBuilderImpl()
}