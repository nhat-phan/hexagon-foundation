package net.ntworld.hexagon.foundation.builder

import kotlin.reflect.KProperty

class NullableProperty<T>(private val property: Property<T>) : Property<T?> {
    override fun hasDefaultValue(): Boolean = true

    override fun getDefaultValue(): T? {
        if (property.hasDefaultValue()) {
            return property.getDefaultValue()
        }
        return null
    }

    override fun getPropertyKey(property: KProperty<*>): String = this.property.getPropertyKey(property)

    override fun getValue(builder: Builder, property: KProperty<*>): T? {
        if (!builder.builderStorage.containsKey(this.property.getPropertyKey(property))) {
            return this.getDefaultValue()
        }
        return this.property.getValue(builder, property)
    }

    override fun setValue(builder: Builder, property: KProperty<*>, value: T?) {
        if (null !== value) {
            this.property.setValue(builder, property, value)
        }
    }
}