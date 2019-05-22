package net.ntworld.hexagon.foundation.validation

interface Rule<T : Any> {
    val message: String

    fun passes(attribute: String, value: T): Boolean
}

//interface StarkBuilder {
//    var number: Int
//    var string: String
//}

//fun test() {
//    val validator = Validator<StarkBuilder> {
//        StarkBuilder::string required { email() + notEmpty } customMessage "test"
//        StarkBuilder::string required email() + notEmptyString
//        StarkBuilder::string { email() and gt("123") }
//
//        StarkBuilder::number { gt(123) }
//        StarkBuilder::number required { gt(123) }
//        StarkBuilder::number required gt(123) and lt()
//        StarkBuilder::number always required and gt(123)
//        StarkBuilder::number always exists and gt(123)
//        StarkBuilder::number always exists
//
//        StarkBuilder::number whenExist { lt() }
//        StarkBuilder::number ifPresent { lt() }
//        StarkBuilder::number optional gt(0)
//    }
//}