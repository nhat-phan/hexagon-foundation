package net.ntworld.hexagon.foundation.validation

import net.ntworld.hexagon.foundation.ValidationResult
import net.ntworld.hexagon.foundation.internal.MessageBagImpl
import net.ntworld.hexagon.foundation.internal.ValidationResultImpl
import net.ntworld.hexagon.foundation.validation.internal.ValidatorItem
import kotlin.reflect.KProperty0

class Validator(block: ValidatorBuilder.() -> Unit) {
    private val data: MutableMap<String, ValidatorItem> = mutableMapOf()

    init {
        ValidatorBuilder(this).apply(block)
    }

    internal fun registerProperty(property: KProperty0<*>, rules: RuleCollection) {
        val key = property.name
        if (data.containsKey(key)) {
            throw Exception("Duplicated property $key")
        }
        data[key] = ValidatorItem(property, rules)
    }

    fun <T : Validatable> validate(input: T): ValidationResult {
        val isValid = this.data.entries.fold(true) { acc, entry ->
            val value = if (input.containsKey(entry.key)) entry.value.property.get() else null
            val valid = entry.value.rules.passes(entry.key, value)

            valid && acc
        }
        return ValidationResultImpl(isValid, MessageBagImpl())
    }
}