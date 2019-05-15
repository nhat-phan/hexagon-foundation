package net.ntworld.hexagon.foundation.builder

import kotlin.reflect.KProperty

open class GenericProperty<T : Any>(private val options: GenericPropertyOptions<T>) : Property<T> {
    override fun hasDefaultValue(): Boolean {
        return null !== options.propertyDefaultValue
    }

    override fun getDefaultValue(): T {
        return options.default
    }

    override fun getPropertyKey(property: KProperty<*>): String {
        return property.name
    }

    override fun getValue(builder: Builder, property: KProperty<*>): T {
        return readValue(builder, property, this)
    }

    override fun setValue(builder: Builder, property: KProperty<*>, value: T) {
        builder.builderStorage.set(
            this.getPropertyKey(property),
            value
        )
    }

    companion object {
        fun <T> readValue(builder: Builder, property: KProperty<*>, builderProperty: Property<T>): T {
            val key = builderProperty.getPropertyKey(property)

            if (builder.builderStorage.containsKey(key)) {
                return builder.builderStorage.get(key)
            }

            if (builderProperty.hasDefaultValue()) {
                return builderProperty.getDefaultValue()
            }
            throw Exception("")
        }
    }
}
