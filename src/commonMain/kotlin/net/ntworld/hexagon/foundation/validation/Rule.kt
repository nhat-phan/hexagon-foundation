package net.ntworld.hexagon.foundation.validation

interface Rule<T : Any> {
    val message: String

    fun passes(attribute: String, value: T?): Boolean
}

interface MorganBuilder {
    var email: String
    var age: Int
}

interface TonyBuilder {
    var email: String
    var age: Int
    val morgan: MorganBuilder
}

interface StarkBuilder {
    var number: Int
    var string: String
    var tony: TonyBuilder
}

fun test() {
    val validator = Validator<StarkBuilder> {
        StarkBuilder::string required {
            rule = email() and notEmptyString
            message = "custom"
        }
        StarkBuilder::string required email() and notEmptyString
        StarkBuilder::string {
            rule = email() and gt("123")
        }

        StarkBuilder::number { rule = gt(123) }
        StarkBuilder::number required { rule = gt(123) }
        StarkBuilder::number required gt(123) and lt()
        StarkBuilder::number always required and gt(123)
        StarkBuilder::number always exists and gt(123)
        StarkBuilder::number always exists and lt()

        StarkBuilder::tony {
            TonyBuilder::age required gt(10) otherwise "test"

            TonyBuilder::morgan {
                MorganBuilder::age required gt(10)
            }
        }
//        StarkBuilder::number whenExist { lt() }
//        StarkBuilder::number ifPresent { lt() }
//        StarkBuilder::number optional gt(0)
    }
}