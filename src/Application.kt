package de.mayflower

import io.ktor.application.*
import io.ktor.client.engine.cio.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.html.*
import kotlinx.html.*
import io.ktor.auth.*
import io.ktor.gson.*
import io.ktor.features.*
import com.fasterxml.jackson.databind.*
import io.ktor.jackson.*
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.logging.*
import io.ktor.request.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.slf4j.event.Level

data class Employee(val name: String)

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)
/*
fun main(args: Array<String>) {
    embeddedServer(
        Netty,
        watchPaths = listOf("/"),
        port = 1234,
        module = Application::module
    ).apply { start(wait = true) }
}
*/
@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {

    install(CallLogging) {
        level = Level.DEBUG
    }

    install(Authentication) {
        basic("myBasicAuth") {
            realm = "Ktor Server"
            validate {
                if (
                    it.name == "test"
                    && it.password == "password"
                ) UserIdPrincipal(it.name) else null
            }
        }
    }

    install(ContentNegotiation) {
        gson {
        }

        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }

    // val client = HttpClient()
/*
    val client = HttpClient(CIO) {
        install(Logging) {
            level = LogLevel.ALL
        }
        BrowserUserAgent() // install default browser-like user-agent
        // install(UserAgent) { agent = "some user agent" }
        engine {
            // threadsCount = 4
            // pipelining = true
        }
    }
*/
    val employeeStack = mutableListOf<Employee>()

    routing {
        get("/") {
            call.respondText("Hello World!", contentType = ContentType.Text.Plain)
        }

        get("/html-dsl") {
            call.respondHtml {
                body {
                    h1 { +"HTML" }
                    ul {
                        for (n in 1..10) {
                            li { +"$n" }
                        }
                    }
                }
            }
        }

        authenticate("myBasicAuth") {
            get("/protected") {
                val principal = call.principal<UserIdPrincipal>()!!
                call.respondText("Hello ${principal.name}")
            }
        }

        get("/json/gson") {
            call.respond(mapOf("hello" to "world"))
        }

        get("/json/jackson") {
            call.respond(mapOf("hello" to "world"))
        }

        get("/users") {
            call.respond(ResponseHelper().allUsers())
        }

        post("/employee") {
            employeeStack.add(call.receive())
            call.respond(HttpStatusCode.Created)
        }
        get("/employee") {
            call.respond(employeeStack)
        }
    }
}
/*
val Application.envKind get() = environment.config.property("ktor.environment").getString()
val Application.isDev get() = envKind == "dev"
val Application.isProd get() = envKind != "dev"
*/
