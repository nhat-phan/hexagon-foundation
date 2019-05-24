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
            rule.passes(attribute, value) && acc
        }
        return startedValid && valid
    }

    internal fun buildErrorMessages(errors: MessageBag, attribute: String, value: T?) {
        if (this.message.isNotEmpty()) {
            this.addMessageToMessageBag(errors, this.message, attribute, value)
            return
        }

        this.addMessageToMessageBag(errors, startedRule.message, attribute, value)
        collection.forEach {
            this.addMessageToMessageBag(errors, it.message, attribute, value)
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

    private fun addMessageToMessageBag(bag: MessageBag, message: String, attribute: String, value: Any?) {
        val formattedMessage = message
            .replace(":attribute", attribute)
            .replace("[attribute]", attribute)
            .replace("{attribute}", attribute)
            .replace(":value", value.toString())
            .replace("[value]", value.toString())
            .replace("{value}", value.toString())

        if (formattedMessage.isNotEmpty()) {
            bag.add(attribute, formattedMessage)
        }
    }
}