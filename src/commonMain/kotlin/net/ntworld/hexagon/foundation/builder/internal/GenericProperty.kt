package net.ntworld.hexagon.foundation.builder.internal

import net.ntworld.hexagon.foundation.builder.Builder
import net.ntworld.hexagon.foundation.builder.GenericPropertyOptions
import net.ntworld.hexagon.foundation.builder.Property
import net.ntworld.hexagon.foundation.exception.NotInitializedException
import kotlin.reflect.KProperty

internal open class GenericProperty<T : Any>(private val options: GenericPropertyOptions<T>) : Property<T> {
    override fun hasDefaultValue(): Boolean = options.hasDefaultValue

    override fun getDefaultValue(): T {
        return options.default
    }

    override fun getPropertyKey(property: KProperty<*>): String {
        return property.name
    }

    override fun getValue(builder: Builder, property: KProperty<*>): T {
        val key = this.getPropertyKey(property)

        if (builder.builderStorage.containsKey(key)) {
            return builder.builderStorage.get(key)
        }

        if (this.hasDefaultValue()) {
            return this.getDefaultValue()
        }
        throw NotInitializedException(builder, property)
    }

    override fun setValue(builder: Builder, property: KProperty<*>, value: T) {
        builder.builderStorage.set(
            this.getPropertyKey(property),
            value
        )
    }
}
