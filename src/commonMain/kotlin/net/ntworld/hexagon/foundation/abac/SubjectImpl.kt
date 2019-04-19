package net.ntworld.hexagon.foundation.abac

data class SubjectImpl(
    override val tenantId: String?,
    override val userId: String?
) : Subject

fun guest(): Subject {
    return SubjectImpl(null, null);
}

fun user(userId: String): Subject {
    return SubjectImpl(null, userId)
}

fun guestOf(tenantId: String): Subject {
    return SubjectImpl(tenantId, null);
}

fun userOf(tenantId: String, userId: String): Subject {
    return SubjectImpl(tenantId, userId);
}

fun makeAuthorizationSubject(userId: String): Subject {
    return SubjectImpl(null, userId);
}

fun makeAuthorizationSubject(tenantId: String, userId: String): Subject {
    return SubjectImpl(tenantId, userId);
}
