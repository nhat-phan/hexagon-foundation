package net.ntworld.hexagon.foundation

import net.ntworld.hexagon.foundation.builder.Builder
import net.ntworld.hexagon.foundation.internal.ArgumentBuilderDelegate

interface ArgumentBuilder : Builder {
    fun reset(): ArgumentBuilder {
        this.builderStorage.clear()

        return this
    }

    var uniqueId: String
        get() {
            return ArgumentBuilderDelegate.uniqueId.getValue(this, this::uniqueId)
        }
        set(value) {
            return ArgumentBuilderDelegate.uniqueId.setValue(this, this::uniqueId, value)
        }

    var currentTenantId: String?
        get() {
            return ArgumentBuilderDelegate.currentTenantId.getValue(this, this::currentTenantId)
        }
        set(value) {
            return ArgumentBuilderDelegate.currentTenantId.setValue(this, this::currentTenantId, value)
        }

    var currentUserId: String?
        get() {
            return ArgumentBuilderDelegate.currentUserId.getValue(this, this::currentUserId)
        }
        set(value) {
            return ArgumentBuilderDelegate.currentUserId.setValue(this, this::currentUserId, value)
        }

    var contextEnvironmentType: String
        get() {
            return ArgumentBuilderDelegate.contextEnvironmentType.getValue(this, this::contextEnvironmentType)
        }
        set(value) {
            return ArgumentBuilderDelegate.contextEnvironmentType.setValue(this, this::contextEnvironmentType, value)
        }

    var contextEnvironmentId: String
        get() {
            return ArgumentBuilderDelegate.contextEnvironmentId.getValue(this, this::contextEnvironmentId)
        }
        set(value) {
            return ArgumentBuilderDelegate.contextEnvironmentId.setValue(this, this::contextEnvironmentId, value)
        }

    var contextDatetime: String
        get() {
            return ArgumentBuilderDelegate.contextDatetime.getValue(this, this::contextDatetime)
        }
        set(value) {
            return ArgumentBuilderDelegate.contextDatetime.setValue(this, this::contextDatetime, value)
        }

    var contextIpAddress: String
        get() {
            return ArgumentBuilderDelegate.contextIpAddress.getValue(this, this::contextIpAddress)
        }
        set(value) {
            return ArgumentBuilderDelegate.contextIpAddress.setValue(this, this::contextIpAddress, value)
        }
}