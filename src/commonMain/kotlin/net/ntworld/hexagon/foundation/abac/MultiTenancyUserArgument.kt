package net.ntworld.hexagon.foundation.abac


interface MultiTenancyUserArgument : AuthorizableArgument {
    override val authorizationData: AuthorizationData<MultiTenancyUser>

    override val authorizationSubject: MultiTenancyUser
        get() = this.authorizationData.subject
}