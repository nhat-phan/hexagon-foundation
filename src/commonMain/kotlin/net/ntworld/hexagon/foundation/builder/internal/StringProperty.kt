package net.ntworld.hexagon.foundation.builder.internal

import net.ntworld.hexagon.foundation.builder.Builder
import kotlin.reflect.KProperty

internal class StringProperty(private val options: StringPropertyOptionsImpl) : GenericProperty<String>(options) {
    override fun getValue(builder: Builder, property: KProperty<*>): String {
        val result = super.getValue(builder, property)
        val sanitizers = ArrayList<(String) -> String>(4)
        if (options.trim) {
            sanitizers.add { it.trim() }
        }

        if (options.uppercase) {
            sanitizers.add { it.toUpperCase() }
        }

        if (options.lowercase) {
            sanitizers.add { it.toLowerCase() }
        }

        val sanitizer = options.propertySanitizer
        if (null !== sanitizer) {
            sanitizers.add(sanitizer)
        }

        return sanitize(sanitizers, result)
    }

    private fun sanitize(sanitizers: ArrayList<(String) -> String>, value: String): String {
        if (sanitizers.isEmpty()) {
            return value
        }
        var result = value
        for (item in sanitizers) {
            result = item(result)
        }
        return result
    }
}