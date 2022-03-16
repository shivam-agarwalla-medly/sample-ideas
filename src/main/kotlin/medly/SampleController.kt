package medly

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import jakarta.inject.Inject

@Controller(value = "/api/sample")
class SampleController(@Inject private val sampleService: SampleService) {

    @Get(value = "/")
    fun getData(): HttpResponse<String> {
        return HttpResponse.ok("Sample Data")
    }

    @Get(value = "/call")
    fun callApi(): HttpResponse<String> {
        return HttpResponse.ok("Data: " + sampleService.getData())
    }
}