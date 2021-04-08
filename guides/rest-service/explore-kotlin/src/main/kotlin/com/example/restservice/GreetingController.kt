package com.example.restservice

import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
@RequestMapping("/greeting")
class GreetingController {
    companion object {
        const val template = "Hello, %s!"
    }
    val counter = AtomicLong()

    @GetMapping("")
    @ApiOperation(value = "Test Sample")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String): Greeting {
        return Greeting(counter.incrementAndGet(), template.format(name))
    }
}