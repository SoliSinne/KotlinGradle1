package org.example

import io.ktor.http.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class Decision(
    val expected: Int,
    val actual: Int,
    val decision: String
)

fun main() {
    embeddedServer(Netty, 8080) {
        routing {
            get("/abc") {
                call.respondText("Hello World!")
            }
            get("/decision") {
                println("WHAT?")
                val decision = Decision(1, 0, decision = "NOT")
                call.respondText(decision.toString(), ContentType.Text.Plain, HttpStatusCode.OK)
            }
            post("/decision") {
                val decision = Json.decodeFromString<Decision>(call.receiveText())
                println("Decision: $decision")
            }
        }
    }.start(wait = true)
}