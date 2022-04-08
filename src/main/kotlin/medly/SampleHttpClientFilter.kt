package medly

import com.amazonaws.xray.AWSXRay
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpRequest
import io.micronaut.http.annotation.Filter
import io.micronaut.http.filter.ClientFilterChain
import io.micronaut.http.filter.HttpClientFilter
import org.reactivestreams.Publisher

@Filter("/**")
class SampleHttpClientFilter : HttpClientFilter {
    override fun doFilter(request: MutableHttpRequest<*>?, chain: ClientFilterChain?): Publisher<out HttpResponse<*>>? {
        val subsegment = AWSXRay.beginSegment("sample-ideas")
        try {
            println("XRayTracing Start For ${request?.uri}")
            val httpObject = mapOf<String, Any>(
                "request" to mapOf<String, Any?>(
                    "method" to request?.methodName,
                    "url" to request?.uri.toString()
                )
            )
            subsegment.putAllHttp(httpObject)
            return chain?.proceed(request)
        } catch (exception: Exception) {
            subsegment.addException(exception)
            println("XRayTracing Failed")
            throw exception
        } finally {
            AWSXRay.endSegment()
            println("XRayTracing End For ${request?.uri}")
        }
    }
}