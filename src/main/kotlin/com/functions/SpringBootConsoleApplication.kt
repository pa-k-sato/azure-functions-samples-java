package com.functions

import com.functions.model.Greeting
import com.functions.model.User
import com.functions.service.MyService
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
@EnableAutoConfiguration
@ComponentScan
class SpringBootConsoleApplication(
    private val myService: MyService
) {
    @Bean
    open fun hello(): (User) -> Greeting {
        return {Greeting("Welcome, ${it.name}")}
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(SpringBootConsoleApplication::class.java, *args)
        }
    }
}
