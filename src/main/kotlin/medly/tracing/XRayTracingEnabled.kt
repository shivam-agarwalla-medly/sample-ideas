package medly.tracing

import io.micronaut.aop.Around

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@Around
annotation class XRayTracingEnabled
