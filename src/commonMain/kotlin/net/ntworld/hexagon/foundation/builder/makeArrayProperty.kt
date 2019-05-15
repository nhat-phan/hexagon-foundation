package net.ntworld.hexagon.foundation.builder

import kotlin.reflect.KProperty

inline fun <reified T> makeArrayProperty(options: ArrayPropertyOptions<T>): Property<Array<T>> {
    return object: Property<Array<T>> {
        override fun hasDefaultValue(): Boolean {
            return null !== options.propertyDefaultValue
        }

        override fun getDefaultValue(): Array<T> {
            return options.default
        }

        override fun getPropertyKey(property: KProperty<*>): String {
            return property.name
        }

        override fun getValue(builder: Builder, property: KProperty<*>): Array<T> {
            val originValue = GenericProperty.readValue(builder, property, this)
            var list = originValue.toList()

            val map = options.propertyMap
            if (null !== map) {
                list = list.map(map)
            }

            val filter = options.propertyFilter
            if (null !== filter) {
                list = list.filter(filter)
            }

            val result = arrayOf(*list.toTypedArray())
            val sanitizer = options.propertySanitizer
            if (null !== sanitizer) {
                return sanitizer(result)
            }
            return result
        }

        override fun setValue(builder: Builder, property: KProperty<*>, value: Array<T>) {
            builder.builderStorage.set(
                this.getPropertyKey(property),
                value
            )
        }
    }
}