package medly

import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

@Client("/api/sample")
interface SampleClient {
    @Get
    fun askData(): String
}