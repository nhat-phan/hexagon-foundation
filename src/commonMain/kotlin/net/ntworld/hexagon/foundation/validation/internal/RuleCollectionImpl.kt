package net.ntworld.hexagon.foundation.validation.internal

import net.ntworld.hexagon.foundation.MessageBag
import net.ntworld.hexagon.foundation.validation.Rule

internal open class RuleCollectionImpl<T : Any>(
    private val startedRule: Rule<Any>,
    internal var customMessage: String? = null
) : Rule<T> {
    private val collection: MutableList<Rule<T>> = mutableListOf()
    override val message: String
        get() {
            return customMessage ?: ""
        }

    override fun passes(attribute: String, value: T?): Boolean {
        val startedValid = startedRule.passes(attribute, value)
        val valid = collection.fold(true) { acc, rule ->
            val passed = rule.passes(attribute, value)

            return acc && passed
        }
        return startedValid && valid
    }

    internal fun buildErrorMessages(errors: MessageBag, attribute: String, value: T?) {
        if (this.message.isNotEmpty()) {
            errors.add(attribute, formatMessage(this.message, attribute, value))
            return
        }

        errors.add(attribute, formatMessage(startedRule.message, attribute, value))
        collection.forEach {
            errors.add(attribute, formatMessage(it.message, attribute, value))
        }
    }

    internal fun addRule(rule: Rule<T>): RuleCollectionImpl<T> {
        if (rule is RuleCollectionImpl<T>) {
            this.collection.addAll(rule.collection)
        } else {
            this.collection.add(rule)
        }
        return this
    }

    private fun formatMessage(message: String, attribute: String, value: Any?): String {
        return message
            .replace(":attribute", attribute)
            .replace("[attribute]", attribute)
            .replace("{attribute}", attribute)
            .replace(":value", value.toString())
            .replace("[value]", value.toString())
            .replace("{value}", value.toString())
    }
}