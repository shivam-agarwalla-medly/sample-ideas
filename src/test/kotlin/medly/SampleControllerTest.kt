package medly

import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.StringSpec
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.kotest.annotation.MicronautTest

@MicronautTest
class SampleControllerTest(@Client("/api/sample") private val httpClient: HttpClient): StringSpec() {

    init {
        "should get data" {
            val response = httpClient.toBlocking().exchange("/", String::class.java)
            response.status shouldBe HttpStatus.OK
            response.body() shouldBe "Sample Data"
        }
    }
}
