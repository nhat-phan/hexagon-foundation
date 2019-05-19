package net.ntworld.hexagon.foundation.builder

import kotlin.reflect.KProperty

interface Property<T> {
    fun hasDefaultValue(): Boolean

    fun getDefaultValue(): T

    fun getPropertyKey(property: KProperty<*>): String

    operator fun getValue(builder: Builder, property: KProperty<*>): T

    operator fun setValue(builder: Builder, property: KProperty<*>, value: T)

    operator fun provideDelegate(builder: Builder, property: KProperty<*>): Property<T> {
        if (this.hasDefaultValue()) {
            builder.builderStorage.set(this.getPropertyKey(property), this.getDefaultValue())
        }
        return this
    }
}
