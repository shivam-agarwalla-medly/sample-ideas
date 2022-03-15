package medly.tracing

import io.kotest.core.spec.style.StringSpec
import io.kotest.core.test.TestCase
import io.kotest.core.test.TestResult
import io.micronaut.aop.MethodInvocationContext
import io.mockk.clearAllMocks
import io.mockk.mockk

class XRayTracingEnabledInterceptorTest: StringSpec() {
    private val methodContext = mockk<MethodInvocationContext<Any, Any>>(relaxed = true)

    override fun afterTest(testCase: TestCase, result: TestResult) {
        super.afterTest(testCase, result)
        clearAllMocks()
    }

    init {
        "should intercept" {
            val xRayTracingEnabledInterceptor = XRayTracingEnabledInterceptor()
            xRayTracingEnabledInterceptor.intercept(methodContext)
        }
    }
}
