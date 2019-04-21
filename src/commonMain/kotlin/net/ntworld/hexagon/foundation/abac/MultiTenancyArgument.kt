package net.ntworld.hexagon.foundation.abac

interface MultiTenancyArgument : AuthorizableArgument {
    override val authorizationData: AuthorizationData<MultiTenancy>

    override val authorizationSubject: MultiTenancy
        get() = this.authorizationData.subject

    override val tenantId: String
        get() = this.authorizationSubject.tenantId
}