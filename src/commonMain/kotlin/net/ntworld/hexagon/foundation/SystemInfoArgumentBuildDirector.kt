package net.ntworld.hexagon.foundation

class SystemInfoArgumentBuildDirector<T : ArgumentBuilder>(
    private val environmentType: String = "local",
    private val environmentId: String = "not-set",
    private val ipAddress: String = "127.0.0.1"
) : ArgumentBuildDirector<T> {
    override fun constructArgument(builder: T) {
        builder.contextEnvironmentType = environmentType
        builder.contextEnvironmentId = environmentId
        builder.contextIpAddress = ipAddress
        builder.contextDatetime = getCurrentDatetimeInUtc()
        builder.uniqueId = generateUuid()
    }
}