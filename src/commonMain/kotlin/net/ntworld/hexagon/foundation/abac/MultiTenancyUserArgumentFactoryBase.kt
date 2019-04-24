package net.ntworld.hexagon.foundation.abac

import net.ntworld.hexagon.foundation.ArgumentFactory
import net.ntworld.hexagon.foundation.MessageBag
import net.ntworld.hexagon.foundation.ArgumentBuilderData
import net.ntworld.hexagon.foundation.BuilderKey
import net.ntworld.hexagon.foundation.MessageBagImpl
import net.ntworld.hexagon.foundation.exception.ValidationException
import net.ntworld.hexagon.foundation.validator.MultiTenancyUserValidator

abstract class MultiTenancyUserArgumentFactoryBase<out A : MultiTenancyUserArgument> :
        ArgumentFactory<AuthorizableArgumentBuilderBase, A> {
    protected val errors: MessageBag = MessageBagImpl()

    abstract fun build(uniqueId: String, authorizationData: AuthorizationData<Subject>, data: ArgumentBuilderData): A

    abstract fun validate(data: ArgumentBuilderData): Boolean

    override fun make(builder: AuthorizableArgumentBuilderBase): A {
        val data = builder.getBuilderData()

        this.errors.clear()
        if (MultiTenancyUserValidator.validate(data, errors) && this.validate(data)) {
            return this.build(
                    data.uniqueId as String,
                    makeAuthorizationData(
                            this.makeSubject(data),
                            this.makeContext(data),
                            data.getValue(BuilderKey.AUTHORIZATION_ACTION.key),
                            data.getValue(BuilderKey.AUTHORIZATION_RESOURCES.key)
                    ),
                    data
            )
        }
        throw ValidationException(this.errors)
    }

    private fun makeSubject(data: ArgumentBuilderData): MultiTenancy {
        val subject = data[BuilderKey.AUTHORIZATION_SUBJECT.key]
        if (null === subject) {
            return userOf(data.getValue(BuilderKey.TENANT_ID.key), data.getValue(BuilderKey.USER_ID.key))
        }
        return subject as MultiTenancy
    }

    private fun makeContext(data: ArgumentBuilderData): Context {
        val context = data[BuilderKey.AUTHORIZATION_CONTEXT.key]
        if (null === context) {
            return makeAuthorizationContext(
                    data.contextEnvironmentType as String,
                    data.contextEnvironmentId as String,
                    data.contextDatetime as String,
                    data.getValue(BuilderKey.CONTEXT_IP_ADDRESS.key),
                    data.getValue(BuilderKey.CONTEXT_LOCATION.key)
            )
        }
        return context as Context
    }
}