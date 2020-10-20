package com.functions

//import com.functions.model.Greeting
//import com.functions.model.User
//import com.functions.service.MyService
//import org.springframework.boot.CommandLineRunner
//import org.springframework.boot.SpringApplication
//import org.springframework.boot.SpringBootConfiguration
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration
//import org.springframework.boot.autoconfigure.SpringBootApplication
//import org.springframework.boot.runApplication
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.ComponentScan
//import org.springframework.context.annotation.Configuration
//import java.util.function.Function
//
////@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan
//class SpringBootConsoleApplication(
//    private val myService: MyService
//) {
//    @Bean
//    open fun hello(): (User) -> Greeting {
//        return {Greeting("Welcome, $it.name")}
//    }
//
//    fun test() = myService.hello("oops")
//}
//
////class SpringBootConsoleApplication {
////    @Bean(name = ["hello"])
////    fun hello(): Function<User, Greeting> {
//////        return Function { Greeting("Welcome, $it.name") }.to
////        return Function { user -> Greeting("Welcome, $user.name") }
////    }
////}
////class SpringBootConsoleApplication(
////    private val service: MyService
////): CommandLineRunner {
////    override fun run(vararg args: String?) {
////        println("aaaaaaaaa")
////        val message = service.hello("spring boot")
////        println(message)
////
////    }
////}
//
//fun main(args: Array<String>) {
////    runApplication<SpringBootConfiguration>(*args)
//    SpringApplication.run(SpringBootConsoleApplication::class.java, *args)
//}
