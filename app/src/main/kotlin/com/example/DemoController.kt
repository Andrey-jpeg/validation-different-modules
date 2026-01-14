package com.example

import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put
import jakarta.validation.Valid

@Controller
class DemoController {

    @Post
    fun demo(@Body @Valid request: Request){
        println(request.list)
    }

    @Put
    fun demo2(@Body @Valid request: ValidatedRequest) {
        println(request.list)
    }

}