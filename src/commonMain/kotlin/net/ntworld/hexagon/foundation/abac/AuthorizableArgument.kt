package net.ntworld.hexagon.foundation.abac

import net.ntworld.hexagon.foundation.Argument

interface AuthorizableArgument : Argument {
    val authorizationData: AuthorizationData

    val authorizationSubject: Subject
        get() = this.authorizationData.subject

    val authorizationContext: Context
        get() = this.authorizationData.context

    val authorizationAction: Action
        get() = this.authorizationData.action

    val authorizationResource: Collection<Resource>
        get() = this.authorizationData.resources

    override val context: Context
        get() = this.authorizationData.context
}
