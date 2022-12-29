package com.application.execute.controller

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

/**********************************************************************************************************************/
@ApiIgnore
@Controller
class IndexController {
    /******************************************************************************************************************/
    val url: String  = "/";
    /******************************************************************************************************************/
    @RequestMapping(value = ["/"], method = [RequestMethod.GET])
    fun  index(model:Model): String {
        return url + "/index";
    }
}
