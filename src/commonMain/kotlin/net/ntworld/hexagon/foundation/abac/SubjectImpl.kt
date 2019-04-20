package net.ntworld.hexagon.foundation.abac

internal data class SubjectImpl(
    override val tenantId: String?,
    override val userId: String?
) : Subject

internal data class UserImpl(
    override val tenantId: String?,
    override val userId: String
) : User

internal data class MultiTenancyUserImpl(
    override val tenantId: String,
    override val userId: String
): MultiTenancyUser

fun guest(): Subject {
    return SubjectImpl(null, null);
}

fun user(userId: String): User {
    return UserImpl(null, userId)
}

fun guestOf(tenantId: String): Subject {
    return SubjectImpl(tenantId, null);
}

fun userOf(tenantId: String, userId: String): MultiTenancyUser {
    return MultiTenancyUserImpl(tenantId, userId);
}

fun makeAuthorizationSubject(): Subject {
    return SubjectImpl(null, null);
}

fun makeAuthorizationSubject(userId: String): User {
    return UserImpl(null, userId);
}

fun makeAuthorizationSubject(tenantId: String, userId: String): MultiTenancyUser {
    return MultiTenancyUserImpl(tenantId, userId);
}
