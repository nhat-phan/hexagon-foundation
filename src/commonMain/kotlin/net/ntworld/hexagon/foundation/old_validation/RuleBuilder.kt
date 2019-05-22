package net.ntworld.hexagon.foundation.old_validation

class RuleBuilder {
    var rule: Rule? = null

    var message: String? = null

    internal fun getRuleCollection(): RuleCollection? {
        val rule = this.rule
        if (null === rule) {
            return null
        }

        if (rule is RuleCollection) {
            return rule
        }

        return RuleCollection(rule, message)
    }

    infix fun otherwise(message: String) {
        this.message = message
    }

    infix fun otherwise(block: () -> String) {
        this.message = block()
    }

    infix fun and(rule: Rule): RuleBuilder {
        val tmp = this.rule
        if (null === tmp) {
            this.rule = rule
        } else {
            this.rule = tmp + rule
        }
        return this
    }
}
