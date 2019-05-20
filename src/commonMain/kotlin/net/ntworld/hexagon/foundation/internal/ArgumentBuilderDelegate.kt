package net.ntworld.hexagon.foundation.internal

import net.ntworld.hexagon.foundation.builder.internal.NullableProperty
import net.ntworld.hexagon.foundation.builder.Property
import net.ntworld.hexagon.foundation.builder.internal.StringProperty
import net.ntworld.hexagon.foundation.builder.internal.StringPropertyOptionsImpl

internal object ArgumentBuilderDelegate {
    val uniqueId: Property<String> = StringProperty(StringPropertyOptionsImpl())

    val currentTenantId: Property<String?> = NullableProperty(StringProperty(StringPropertyOptionsImpl()))

    val currentUserId: Property<String?> = NullableProperty(StringProperty(StringPropertyOptionsImpl()))

    val contextEnvironmentType: Property<String> = StringProperty(StringPropertyOptionsImpl())

    val contextEnvironmentId: Property<String> = StringProperty(StringPropertyOptionsImpl())

    val contextDatetime: Property<String> = StringProperty(StringPropertyOptionsImpl())

    val contextIpAddress: Property<String> = StringProperty(StringPropertyOptionsImpl())
}