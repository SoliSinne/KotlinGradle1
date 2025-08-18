package org.example

import io.ktor.http.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json
import org.example.api.InputData

fun main() {
    embeddedServer(Netty, 8080) {
        routing {
            post("/check") {
                val inputData = Json.decodeFromString<InputData>(call.receiveText())
                val decision = theChiSquareTestLib(inputData)
                call.respondText(decision.toString(), ContentType.Text.Plain, HttpStatusCode.Created)
            }
        }
    }.start(wait = true)
}