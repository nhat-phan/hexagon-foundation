package net.ntworld.hexagon.foundation.validation

import net.ntworld.hexagon.foundation.ValidationResult
import net.ntworld.hexagon.foundation.internal.MessageBagImpl
import net.ntworld.hexagon.foundation.internal.ValidationResultImpl
import net.ntworld.hexagon.foundation.validation.internal.RuleCollectionImpl
import net.ntworld.hexagon.foundation.validation.internal.ValidatorBuilderImpl
import net.ntworld.hexagon.foundation.validation.internal.ValidatorItem
import kotlin.reflect.KProperty0
import kotlin.reflect.KProperty1

class Validator<T : Any>(block: ValidatorBuilder<T>.() -> Unit) : Rule<T> {
    override val message: String = ""

    override fun passes(attribute: String, value: T?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private val data: MutableMap<String, ValidatorItem<T, *>> = mutableMapOf()

    init {
        ValidatorBuilderImpl(this).apply(block)
    }

    internal fun <R : Any> registerProperty(property: KProperty0<R?>, rules: RuleCollectionImpl<R>) {
        val key = property.name
        if (!data.containsKey(key)) {
            data[key] = ValidatorItem(property, null, rules)
            return
        }

        @Suppress("UNCHECKED_CAST")
        val item = data[key] as ValidatorItem<T, R>
        item.rules.addRule(rules)
    }

    internal fun <R : Any> registerProperty(property: KProperty1<T, R?>, rules: RuleCollectionImpl<R>) {
        val key = property.name
        if (!data.containsKey(key)) {
            data[key] = ValidatorItem(null, property, rules)
            return
        }

        @Suppress("UNCHECKED_CAST")
        val item = data[key] as ValidatorItem<T, R>
        item.rules.addRule(rules)
    }

    fun validate(input: T): ValidationResult {
        val errors = MessageBagImpl()
        val isValid = this.data.entries.fold(true) { acc, entry ->
            entry.value.validate(entry.key, input, errors)
        }
        return ValidationResultImpl(isValid, errors)
    }
}
