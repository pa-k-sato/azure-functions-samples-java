package com.functions;

import com.functions.model.Greeting;
import com.functions.model.User;
import com.functions.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.function.Function;


@EnableAutoConfiguration
@ComponentScan
public class SpringBootConsoleApplicationKt {
//    @Autowired
//    MyService myService;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootConsoleApplicationKt.class, args);
    }

    @Bean
    public Function<User, Greeting> hello() {
        return user -> new Greeting("Welcome, " + user.getName());
        // これも動く
        // return user -> new Greeting("Welcome, " + myService.hello(user.getName()));
    }
}

