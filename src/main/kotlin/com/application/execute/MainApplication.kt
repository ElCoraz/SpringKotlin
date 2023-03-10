package com.application.execute

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**********************************************************************************************************************/
@EnableWebMvc
@EnableSwagger2
@EnableScheduling
@SpringBootApplication
class MainApplication
/**********************************************************************************************************************/
fun main(args: Array<String>) {
	runApplication<MainApplication>(*args)
}