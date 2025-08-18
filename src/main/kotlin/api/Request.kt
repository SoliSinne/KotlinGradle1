package org.example.api

import kotlinx.serialization.Serializable

@Serializable
data class InputData(
    val chiLevel: Int,
    val documentData: String,
)