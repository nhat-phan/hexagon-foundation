package net.ntworld.hexagon.foundation.abac.internal

import net.ntworld.hexagon.foundation.abac.Action
import net.ntworld.hexagon.foundation.abac.Context
import net.ntworld.hexagon.foundation.abac.Resource
import net.ntworld.hexagon.foundation.abac.Subject
import net.ntworld.hexagon.foundation.builder.Property
import net.ntworld.hexagon.foundation.builder.internal.GenericProperty
import net.ntworld.hexagon.foundation.builder.internal.GenericPropertyOptionsImpl
import net.ntworld.hexagon.foundation.builder.internal.IterableProperty
import net.ntworld.hexagon.foundation.builder.internal.IterablePropertyFactory
import net.ntworld.hexagon.foundation.builder.internal.IterablePropertyOptionsImpl

internal object AuthorizationDataBuilderDelegate {
    val subject: Property<Subject> = GenericProperty(GenericPropertyOptionsImpl())

    val context: Property<Context> = GenericProperty(GenericPropertyOptionsImpl())

    val action: Property<Action> = GenericProperty(GenericPropertyOptionsImpl())

    val resources: IterableProperty<Resource, Collection<Resource>> =
        IterablePropertyFactory.makeCollection(
            IterablePropertyOptionsImpl<Resource, Collection<Resource>>(
                defaultValue = mutableListOf(),
                map = null,
                filter = null,
                sanitize = null
            )
        )
}