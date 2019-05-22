package net.ntworld.hexagon.foundation.old_validation

import net.ntworld.hexagon.foundation.MessageBag


class RuleCollection(base: Rule, customMessage: String?) : Rule {
    private val collection: MutableList<Rule> = mutableListOf(base)
    override val message: String = customMessage ?: ""

    override fun passes(attribute: String, value: Any?): Boolean {
        return collection.fold(true) { acc, rule ->
            val passed = rule.passes(attribute, value)

            return acc && passed
        }
    }

    internal fun buildErrorMessages(errors: MessageBag, attribute: String, value: Any?) {
        if (this.message.isNotEmpty()) {
            errors.add(attribute, formatMessage(this.message, attribute, value))
            return
        }

        collection.forEach {
            errors.add(attribute, formatMessage(it.message, attribute, value))
        }
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

    fun add(rule: Rule) {
        collection.add(rule)
    }

    fun add(rules: RuleCollection) {
        for (rule in rules.collection) {
            this.collection.add(rule)
        }
    }

    operator fun plus(rule: Rule): Rule {
        add(rule)

        return this
    }
}