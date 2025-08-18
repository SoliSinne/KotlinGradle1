package org.example

import io.ktor.http.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json
import org.example.api.Decision
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
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
            post("/decide") {
                val decision = Json.decodeFromString<Decision>(call.receiveText())
                println("Decision: $decision, ${Clock.System.now()}")
                call.respondText(decision.toString(), ContentType.Text.Plain, HttpStatusCode.Created)
            }
        }
    }.start(wait = true)
}