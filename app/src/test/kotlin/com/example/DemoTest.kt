package com.example

import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

@MicronautTest
class DemoTest {

    @Inject
    lateinit var application: EmbeddedApplication<*>

    @Inject
    @Client("/")
    lateinit var client: HttpClient

    @Test
    fun testItWorks() {
        Assertions.assertTrue(application.isRunning)
    }

    @Test
    fun `test validation - different modules`() {

        val blockingClient = client.toBlocking()
        val request = HttpRequest.POST(
            "", """
        {
            "list": [null, ""]
        }
            """.trimIndent()
        )

        val result = runCatching { blockingClient.exchange(request, String::class.java) }


        val exception = result.exceptionOrNull()!!
        val clientException = exception as HttpClientResponseException

        assertEquals(HttpStatus.BAD_REQUEST, clientException.status)
    }

    @Test
    fun `test validation - same module`() {

        val blockingClient = client.toBlocking()
        val request = HttpRequest.PUT(
            "", """
        {
            "list": [null, ""]
        }
            """.trimIndent()
        )

        val result = runCatching { blockingClient.exchange(request, String::class.java) }

        val exception = result.exceptionOrNull()!!
        val clientException = exception as HttpClientResponseException

        assertEquals(HttpStatus.BAD_REQUEST, clientException.status)
    }

}
