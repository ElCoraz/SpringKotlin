package com.application.execute.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping


@Controller
class PageController {
    @get:GetMapping("/international")
    val internationalPage: String
        get() = "international"
}