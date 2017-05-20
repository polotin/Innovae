package com.innovae.controller;

import com.innovae.domain.UserDomain;
import com.innovae.model.User;
import com.innovae.service.AccountService;
import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Polotin on 2017/5/19.
 */
@RestController
@EnableAutoConfiguration
public class AccountController{
    private static Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    AccountService accountService;

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("login");
    }

    //  登录
    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    public UserDomain login(@RequestBody User user) throws Exception{
        return accountService.UserLogin(user);
    }
}
