package com.application.execute.controller

import com.application.execute.service.AssertsService
import org.springframework.beans.factory.annotation.Autowired
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
    @Autowired
    private lateinit var assertsService: AssertsService
    /******************************************************************************************************************/
    @RequestMapping(value = ["/"], method = [RequestMethod.GET])
    fun index(model:Model): String {

        model.addAttribute("title", "first page")
        model.addAttribute("assertsHead", assertsService.headAsserts())
        model.addAttribute("assertsFooter", assertsService.footerAsserts())

        return "/index";
    }
}
