package net.ntworld.hexagon.foundation.validation


class RuleCollection(private val base: Rule, private val customMessage: String?) : Rule {
    private val collection: MutableList<Rule> = mutableListOf(base)
    override val message: String = customMessage ?: ""

    override fun passes(attribute: String, value: Any?): Boolean {
        return collection.fold(true) { acc, rule ->
            val passed = rule.passes(attribute, value)

            return acc && passed
        }
    }

    internal fun hasCustomMessage(): Boolean {
        return null === customMessage
    }

    internal fun getMessages(): List<String> {
        return collection.map { it.message }
    }

    fun add(rule: Rule) {
        collection.add(rule)
    }

    operator fun plus(rule: Rule): Rule {
        add(rule)

        return this
    }
}