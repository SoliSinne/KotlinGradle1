package org.example

import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import kotlinx.serialization.Serializable
import java.math.BigInteger

@Serializable
data class Decision(val expected: BigInteger, val actual: BigInteger, val decision: String)

fun main() {
    embeddedServer(Netty, 8080) {
        routing {
            get("/abc") {
                call.respondText("Hello World!")
            }
            get("/decision") {
                val decision = Decision(BigInteger.valueOf(1), BigInteger.valueOf(0), decision = "NOT")
                call.respondText(decision.toString(), ContentType.Text.Plain, HttpStatusCode.OK)
            }
        }
    }.start(wait = true)
}