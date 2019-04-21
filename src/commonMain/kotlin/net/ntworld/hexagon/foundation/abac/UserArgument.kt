package net.ntworld.hexagon.foundation.abac

interface UserArgument : AuthorizableArgument {
    override val authorizationData: AuthorizationData<User>

    override val authorizationSubject: User
        get() = this.authorizationData.subject
}