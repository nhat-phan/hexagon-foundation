package net.ntworld.hexagon.foundation.abac

interface User: Subject {
    override val userId: String
}