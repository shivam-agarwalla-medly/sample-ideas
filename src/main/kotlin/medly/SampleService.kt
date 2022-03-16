package medly

import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class SampleService(
    @Inject private val httpClient: SampleClient
) {
    fun getData(): String {
        val sampleData = httpClient.askData()
        println(sampleData)
        return sampleData
    }
}