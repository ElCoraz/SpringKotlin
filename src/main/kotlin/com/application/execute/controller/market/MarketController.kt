package com.application.execute.controller.market

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
class MarketController {
    /******************************************************************************************************************/
    @Autowired
    private lateinit var assertsService: AssertsService
    /******************************************************************************************************************/
    @RequestMapping(value = ["/market"], method = [RequestMethod.GET])
    fun index(model:Model): String {
        model.addAttribute("title", "market")
        model.addAttribute("asserts", assertsService.asserts())

        return "/market/index"
    }
    /******************************************************************************************************************/
    @RequestMapping(value = ["/market/restore"], method = [RequestMethod.GET])
    fun forgot(model:Model): String {
        model.addAttribute("title", "market")
        model.addAttribute("asserts", assertsService.asserts())

        return "/authorization/restore"
    }
}
