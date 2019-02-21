package com.nowcoder.controller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Component
public class SettingController {
    private static final Logger logger = LoggerFactory.getLogger(SettingController.class);

    @RequestMapping(path = {"/setting"})
    @ResponseBody
    public String setting(){
        return "Setting:OK!";
    }

}
