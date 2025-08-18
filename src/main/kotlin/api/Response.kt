package org.example.api

import kotlinx.serialization.Serializable

@Serializable
data class Decision(
    val expected: Int,
    val actual: Int,
    val decision: String,
)