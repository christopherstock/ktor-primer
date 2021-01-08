package de.mayflower

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
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
import io.ktor.client.features.logging.*
import io.ktor.client.features.UserAgent
import io.ktor.client.features.BrowserUserAgent
import kotlin.test.*
import io.ktor.server.testing.*

class ApplicationTest {
    @Test
    fun testRoot() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("HELLO WORLD!", response.content)
            }
        }
    }
}
