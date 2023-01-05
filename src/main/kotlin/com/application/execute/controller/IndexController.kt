package com.application.execute.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import springfox.documentation.annotations.ApiIgnore

/**********************************************************************************************************************/
@ApiIgnore
@Controller
class IndexController {
    /******************************************************************************************************************/
    @RequestMapping(value = ["/"], method = [RequestMethod.GET])
    fun index(model:Model): String {
        return "redirect:/market";
    }
}
