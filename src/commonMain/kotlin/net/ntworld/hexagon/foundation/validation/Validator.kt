package net.ntworld.hexagon.foundation.validation

import net.ntworld.hexagon.foundation.ValidationResult
import net.ntworld.hexagon.foundation.builder.Builder
import net.ntworld.hexagon.foundation.internal.MessageBagImpl
import net.ntworld.hexagon.foundation.internal.ValidationResultImpl
import net.ntworld.hexagon.foundation.validation.internal.ValidatorItem
import kotlin.reflect.KProperty0
import kotlin.reflect.KProperty1

class Validator<T>(block: ValidatorBuilder<T>.() -> Unit) {
    private val data: MutableMap<String, ValidatorItem<T>> = mutableMapOf()

    init {
        ValidatorBuilder(this).apply(block)
    }

    internal fun registerProperty(property: KProperty0<*>, rules: RuleCollection) {
        val key = property.name
        if (!data.containsKey(key)) {
            data[key] = ValidatorItem<T>(property, null, rules)
            return
        }

        val item = data[key] as ValidatorItem<T>
        item.rules.add(rules)
    }

    internal fun registerProperty(property: KProperty1<T, *>, rules: RuleCollection) {
        val key = property.name
        if (!data.containsKey(key)) {
            data[key] = ValidatorItem(null, property, rules)
            return
        }

        val item = data[key] as ValidatorItem<T>
        item.rules.add(rules)
    }

    fun validate(input: T): ValidationResult {
        val errors = MessageBagImpl()
        val isValid = this.data.entries.fold(true) { acc, entry ->
            val value = this.getValue(input, entry)
            val rules = entry.value.rules
            val valid = rules.passes(entry.key, value)
            if (!valid) {
                rules.buildErrorMessages(errors, entry.key, value)
            }

            valid && acc
        }

        return ValidationResultImpl(isValid, errors)
    }

    private fun getValue(input: T, entry: Map.Entry<String, ValidatorItem<T>>): Any? {
        when (input) {
            is Validatable -> {
                if (input.containsKey(entry.key)) {
                    return this.getValidationItemValue(input, entry.value)
                }
                return null
            }
            else -> return this.getValidationItemValue(input, entry.value)
        }
    }

    private fun getValidationItemValue(input: T, item: ValidatorItem<T>): Any? {
        if (null !== item.property0) {
            return item.property0.get()
        }
        return (item.property1 as KProperty1<T, *>).get(input)
    }
}