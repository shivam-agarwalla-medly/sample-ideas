package medly.tracing

import com.amazonaws.xray.AWSXRay
import io.micronaut.aop.InterceptorBean
import io.micronaut.aop.MethodInterceptor
import io.micronaut.aop.MethodInvocationContext
import jakarta.inject.Singleton


@Singleton
@InterceptorBean(XRayTracingEnabled::class)
class XRayTracingEnabledInterceptor: MethodInterceptor<Any, Any> {
    override fun intercept(context: MethodInvocationContext<Any, Any>): Any? {
        val subsegment = AWSXRay.beginSegment("sample-ideas")
        try {
            println("XRayTracing Start")
            return context.proceed().also { println("XRayTracing End") }
        } catch (exception: Exception) {
            subsegment.addException(exception);
            println("XRayTracing Failed")
            throw exception
        } finally {
            AWSXRay.endSegment()
        }
    }
}
