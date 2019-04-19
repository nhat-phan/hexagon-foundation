package net.ntworld.hexagon.foundation.abac

data class SubjectImpl(
    override val multiTenancyId: String?,
    override val userId: String?
) : Subject

fun guest(): Subject {
    return SubjectImpl(null, null);
}

fun user(userId: String): Subject {
    return SubjectImpl(null, userId)
}

fun guestOf(multiTenancyId: String): Subject {
    return SubjectImpl(multiTenancyId, null);
}

fun userOf(multiTenancyId: String, userId: String): Subject {
    return SubjectImpl(multiTenancyId, userId);
}

fun makeAuthorizationSubject(userId: String): Subject {
    return SubjectImpl(null, userId);
}

fun makeAuthorizationSubject(multiTenancyId: String, userId: String): Subject {
    return SubjectImpl(multiTenancyId, userId);
}
