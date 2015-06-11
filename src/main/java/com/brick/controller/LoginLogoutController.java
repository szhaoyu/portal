package com.brick.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
@Slf4j
public class LoginLogoutController {

	@RequestMapping("")
    public String index(){
        return "index";
    }
	
    /**
     * Open login page
     *
     * @return String
     */
    @RequestMapping(value= "/login", method = RequestMethod.GET)
    public String getLoginPage(Model model, @RequestParam(required = false) String error) {
    	if( error != null ){
    		model.addAttribute("error", "用户名不存在或者密码错误");
    	}
        return "login";
    }
    
    /*
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage(@RequestParam Optional<String> error) {
        LOGGER.debug("Getting login page, error={}", error);
        return new ModelAndView("login", "error", error);
    }
     */

    /**
     * Open login page
     *
     * @return String
     */
    @RequestMapping(value= "/logout", method = RequestMethod.GET)
    public String getLogoutPage() {
        return "redirect:/login";
    }
}
