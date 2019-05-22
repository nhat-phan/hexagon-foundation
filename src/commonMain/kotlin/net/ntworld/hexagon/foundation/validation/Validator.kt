package net.ntworld.hexagon.foundation.validation

import net.ntworld.hexagon.foundation.ValidationResult
import net.ntworld.hexagon.foundation.internal.MessageBagImpl
import net.ntworld.hexagon.foundation.internal.ValidationResultImpl
import net.ntworld.hexagon.foundation.validation.internal.ValidatorItem
import kotlin.reflect.KProperty0
import kotlin.reflect.KProperty1

class Validator<T : Any>(block: ValidatorBuilder<T>.() -> Unit) {
    private val data: MutableMap<String, ValidatorItem<T, *>> = mutableMapOf()

    init {
        // ValidatorBuilder(this).apply(block)
    }

    internal fun <R : Any> registerProperty(property: KProperty0<R>, rules: RuleCollection<R>) {
        val key = property.name
        if (!data.containsKey(key)) {
            data[key] = ValidatorItem(property, null, rules)
            return
        }

        @Suppress("UNCHECKED_CAST")
        val item = data[key] as ValidatorItem<T, R>
        item.rules.addAll(rules)
    }

    internal fun <R : Any> registerProperty(property: KProperty1<T, R>, rules: RuleCollection<R>) {
        val key = property.name
        if (!data.containsKey(key)) {
            data[key] = ValidatorItem(null, property, rules)
            return
        }

        @Suppress("UNCHECKED_CAST")
        val item = data[key] as ValidatorItem<T, R>
        item.rules.addAll(rules)
    }

    fun validate(input: T): ValidationResult {
        val errors = MessageBagImpl()
        val isValid = this.data.entries.fold(true) { acc, entry ->
            entry.value.validate(entry.key, input, errors)
        }
        return ValidationResultImpl(isValid, errors)
    }
}
