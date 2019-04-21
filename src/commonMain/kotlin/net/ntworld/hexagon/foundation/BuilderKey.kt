package net.ntworld.hexagon.foundation

internal enum class BuilderKey(val key: String) {
    UNIQUE_ID("foundation.uniqueId"),
    TENANT_ID("foundation.tenantId"),
    USER_ID("foundation.userId"),

    CONTEXT_ENVIRONMENT_TYPE("foundation.contextEnvironmentType"),
    CONTEXT_ENVIRONMENT_ID("foundation.contextEnvironmentId"),
    CONTEXT_DATETIME("foundation.contextDatetime"),
    CONTEXT_IP_ADDRESS("foundation.contextIpAddress"),
    CONTEXT_LOCATION("foundation.contextLocation"),

    AUTHORIZATION_SUBJECT("foundation.authorizationSubject"),
    AUTHORIZATION_CONTEXT("foundation.authorizationContext"),
    AUTHORIZATION_ACTION("foundation.authorizationAction"),
    AUTHORIZATION_RESOURCES("foundation.authorizationResources"),
}