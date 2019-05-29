package net.ntworld.hexagon.foundation

import java.time.Clock
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

internal actual fun generateUuid(): String {
    return UUID.randomUUID().toString()
}

internal actual fun getCurrentDatetimeInUtc(): String {
    return LocalDateTime.now(Clock.systemUTC()).format(DateTimeFormatter.ISO_DATE_TIME)
}