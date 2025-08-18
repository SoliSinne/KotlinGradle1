package org.example.api

import kotlinx.serialization.Serializable

@Serializable
data class Input(
    val chiLevel: Int,
    val documentData: String,
)