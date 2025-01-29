package com.example

import io.micronaut.core.annotation.Introspected
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put
import jakarta.validation.Valid

@Introspected(
    classes = [Request::class,
        ValidatedRequest::class
    ]
)
@Controller
class DemoController {

    @Post
    fun demo(@Body @Valid request: Request): Request {
        return request
    }

    @Put
    fun demo2(@Body @Valid request: ValidatedRequest) {
        println(request.list)
    }

}