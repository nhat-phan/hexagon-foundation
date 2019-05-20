package net.ntworld.hexagon.foundation.builder

interface StringPropertyOptions : GenericPropertyOptions<String> {
    var trim: Boolean
    var uppercase: Boolean
    var lowercase: Boolean
    var sanitize: (String) -> String
}