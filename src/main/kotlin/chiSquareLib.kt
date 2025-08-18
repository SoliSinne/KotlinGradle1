package org.example

import org.example.api.Decision
import org.example.api.InputData
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
fun theChiSquareTestLib(inputData: InputData): Decision {
    println("InputData: $inputData, ${Clock.System.now()}")
    return Decision(1, 0, "Not able to give a proper decision.")
}