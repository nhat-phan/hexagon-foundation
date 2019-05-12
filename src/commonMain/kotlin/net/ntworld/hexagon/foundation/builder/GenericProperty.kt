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
        return options.propertyName ?: property.name
    }

    override fun getValue(builder: Builder, property: KProperty<*>): T {
        val key = this.getPropertyKey(property)

        if (builder.builderStorage.containsKey(key)) {
            return builder.builderStorage.get(key)
        }

        if (this.hasDefaultValue()) {
            return this.getDefaultValue()
        }
        throw Exception("")
    }

    override fun setValue(builder: Builder, property: KProperty<*>, value: T) {
        builder.builderStorage.set(
            this.getPropertyKey(property),
            value
        )
    }
}
