package net.ntworld.hexagon.foundation.validation.internal

import net.ntworld.hexagon.foundation.validation.MessageBag
import net.ntworld.hexagon.foundation.validation.Rule
import net.ntworld.hexagon.foundation.validation.Validatable
import kotlin.reflect.KProperty0
import kotlin.reflect.KProperty1

internal class ValidatorItem<T, R : Any>(
    val property0: KProperty0<R?>?,
    val property1: KProperty1<T, R?>?,
    val rules: RuleCollectionImpl<R>
) {
    internal fun validate(attribute: String, input: T, errors: MessageBag): Boolean {
        val value = this.getValue(attribute, input)
        val valid = rules.passes(attribute, value)
        if (!valid) {
            rules.buildErrorMessages(errors, attribute, value)
        }
        return valid
    }

    internal fun buildErrorMessages(errors: MessageBag, attributeDisplayed: String, attribute: String, input: T) {
        rules.buildErrorMessages(
            errors, attributeDisplayed, this.getValue(attribute, input)
        )
    }

    internal fun merge(item: ValidatorItem<*, *>) {
        this.rules.addRule(item.rules as Rule<R>)
    }

    private fun getValue(attribute: String, input: T): R? {
        when (input) {
            is Validatable -> {
                if (input.containsKey(attribute)) {
                    return this.getValidationItemValue(input)
                }
                return null
            }
            else -> return this.getValidationItemValue(input)
        }
    }

    private fun getValidationItemValue(input: T): R? {
        if (null !== property0) {
            return property0.get()
        }
        return property1!!.get(input)
    }
}