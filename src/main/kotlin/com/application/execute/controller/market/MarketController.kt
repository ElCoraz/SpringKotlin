package com.application.execute.controller.market

import com.application.execute.model.Index
import com.application.execute.repository.UsersRepository
import com.application.execute.service.AssertsService
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import springfox.documentation.annotations.ApiIgnore
import java.io.File
import java.util.*
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse


/**********************************************************************************************************************/
@ApiIgnore
@Controller
class MarketController {
    /******************************************************************************************************************/
    @Autowired
    private lateinit var assertsService: AssertsService
    /******************************************************************************************************************/
    @Autowired
    private lateinit var usersRepository: UsersRepository
    /******************************************************************************************************************/
    @RequestMapping(value = ["/market"], method = [RequestMethod.GET])
    fun index(model:Model, @CookieValue(name = "lang", defaultValue = "en") lang:String): String {
        return loadIndex(model, lang)
    }

    /******************************************************************************************************************/
    @RequestMapping(value = ["/market/language/{lang}"], method = [RequestMethod.GET])
    fun language(model:Model, response: HttpServletResponse, @PathVariable lang:String): String {
        val cookie = Cookie("lang", lang)

        cookie.path = "/"
        cookie.maxAge = 3600

        response.addCookie(cookie)

        return loadIndex(model, lang)
    }
    /******************************************************************************************************************/
    @RequestMapping(value = ["/market/restore"], method = [RequestMethod.GET])
    fun forgot(model:Model): String {
        model.addAttribute("title", "market")
        model.addAttribute("asserts", assertsService.asserts())

        return "/authorization/restore"
    }
    /******************************************************************************************************************/
    fun loadIndex(model:Model, lang:String): String {
        model.addAttribute("title", "market")
        model.addAttribute("asserts", assertsService.asserts())

        model.addAttribute("data", getData(Locale(lang)))

        return "/market/index"
    }
    /******************************************************************************************************************/
    fun getData(local: Locale = Locale("en")): Index? {
        return (ObjectMapper()).readValue(File("src/main/resources/lang/messages_$local.json"), Index::class.java)
    }
}
