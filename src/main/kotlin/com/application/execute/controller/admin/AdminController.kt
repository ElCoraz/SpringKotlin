package com.application.execute.controller.admin

import com.application.execute.service.AssertsService
import com.application.execute.service.SecurityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import springfox.documentation.annotations.ApiIgnore


/**********************************************************************************************************************/
@ApiIgnore
@Controller
class AdminController {
    /******************************************************************************************************************/
    @Autowired
    private lateinit var assertsService: AssertsService
    /******************************************************************************************************************/
    @Autowired
    private lateinit var securityService: SecurityService
    /******************************************************************************************************************/
    @RequestMapping(value = ["/admin"], method = [RequestMethod.GET])
    fun index(model:Model): String {
        if (!securityService.isAdmin()) {
            return "redirect:/market"
        }

        model.addAttribute("title", "admin")
        model.addAttribute("asserts", assertsService.asserts())

        return "/admin/index"
    }
}
