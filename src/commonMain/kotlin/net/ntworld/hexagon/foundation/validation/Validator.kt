package net.ntworld.hexagon.foundation.validation

import net.ntworld.hexagon.foundation.MessageBag
import net.ntworld.hexagon.foundation.ValidationResult
import net.ntworld.hexagon.foundation.internal.MessageBagImpl
import net.ntworld.hexagon.foundation.internal.ValidationResultImpl
import net.ntworld.hexagon.foundation.validation.internal.RuleCollectionImpl
import net.ntworld.hexagon.foundation.validation.internal.ValidatorBuilderImpl
import net.ntworld.hexagon.foundation.validation.internal.ValidatorItem
import kotlin.reflect.KProperty0
import kotlin.reflect.KProperty1

class Validator<T : Any>(block: ValidatorBuilder<T>.() -> Unit) : Rule<T> {
    override val message: String = MESSAGE_NESTED_VALIDATOR

    override fun passes(attribute: String, value: T?): Boolean {
        if (null !== value) {
            return this.validate(value).isValid
        }
        return true
    }

    internal fun buildErrorMessages(errors: MessageBag, attribute: String, value: T?) {
        this.data.entries.forEach {
            it.value.buildErrorMessages(errors, "$attribute.${it.key}", it.key, value!!)
        }
    }

    private val parents: MutableSet<Validator<T>> = mutableSetOf()
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

    internal fun extend(validator: Validator<T>) {
        this.parents.add(validator)
    }

    fun validate(input: T): ValidationResult {
        val errors = MessageBagImpl()
        val isParentsValid = this.parents.fold(true, { acc, validator ->
            this.runValidation(validator, input, errors) && acc
        })

        val isValid = this.runValidation(this, input, errors)
        return ValidationResultImpl(isParentsValid && isValid, errors)
    }

    private fun runValidation(validator: Validator<T>, input: T, errors: MessageBag): Boolean {
        return validator.data.entries.fold(true) { acc, entry ->
            entry.value.validate(entry.key, input, errors) && acc
        }
    }
}
