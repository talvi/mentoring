package com.epam

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.boot.SpringApplication

/**
 * Created by Talvi on 29.11.2014.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
class Application {

    static void main(String[] args) {
        SpringApplication.run Application, args
    }

}
