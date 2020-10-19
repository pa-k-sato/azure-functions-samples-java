package com.functions

import com.functions.service.MyService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

//@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
class SpringBootConsoleApplication(
    private val service: MyService
): CommandLineRunner {
    override fun run(vararg args: String?) {
        println("aaaaaaaaa")
        val message = service.hello("spring boot")
        println(message)

    }
}

fun main(args: Array<String>) {
//    runApplication<SpringBootConfiguration>(*args)
    SpringApplication.run(SpringBootConsoleApplication::class.java, *args)
}
