package medly

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller(value = "/api/sample")
class SampleController {

    @Get
    fun getData(): HttpResponse<String> {
        return HttpResponse.ok("Sample Data")
    }
}