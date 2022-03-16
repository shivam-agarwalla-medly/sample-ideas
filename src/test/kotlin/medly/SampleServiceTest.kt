package medly

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk

class SampleServiceTest: StringSpec() {
    private val sampleClient = mockk<SampleClient>()
    private val sampleService = SampleService(sampleClient)

    init {
        "should get data" {
            every { sampleClient.askData() } returns "Data"

            sampleService.getData() shouldBe "Data"
        }
    }
}