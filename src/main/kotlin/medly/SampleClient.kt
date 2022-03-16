package medly

import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import medly.tracing.XRayTracingEnabled

@Client("/api/sample")
@XRayTracingEnabled
interface SampleClient {
    @Get
    fun askData(): String
}