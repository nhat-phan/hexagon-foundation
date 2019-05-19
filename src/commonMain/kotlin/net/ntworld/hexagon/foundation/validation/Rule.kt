package net.ntworld.hexagon.foundation.validation

interface Rule {
    val message: String

    fun passes(attribute: String, value: Any?): Boolean
}

//class Test : ArgumentBuilderBase() {
//    var task: String by this
//}
//fun test() {
//    Validator<Test> {
//        Test::task {
//            rule = required
//            message = "required"
//        }
//
//        Test::task must gt(3) and required and notEmpty otherwise {
//            message = "required"
//        }
//    }
//}