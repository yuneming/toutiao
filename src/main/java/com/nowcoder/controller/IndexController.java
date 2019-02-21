package com.nowcoder.controller;

import com.nowcoder.model.User;
import com.nowcoder.service.ToutiaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@Controller
public class IndexController {

    @Autowired
    private ToutiaoService toutiaoService;

    @RequestMapping(path = {"/","/index"})
    @ResponseBody
    public String index(){

        return "hello newcoder"+toutiaoService.say();
    }

    @RequestMapping(path = {"/profile/{groupId}/{userId}"})
    @ResponseBody
    public String profile(@PathVariable("groupId") String groupId,
                          @PathVariable("userId") int userId,
                          @RequestParam(value = "type",defaultValue = "1") int type,
                          @RequestParam(value = "key", defaultValue = "newcoder") String key){
        return String.format("{%s},{%d},{%d},{%s}",groupId,userId,type,key);

    }

    @RequestMapping(path = {"/vm"})
    public String news(Model model){
        model.addAttribute("value","sd");
        model.addAttribute("user",new User("dsd"));
        return "news";
    }
    @RequestMapping(path = {"/request"})
    @ResponseBody
    public String request(HttpServletRequest request,
                          HttpServletResponse response,
                          HttpSession session){
        StringBuilder sb = new StringBuilder();
        for (Cookie cookie :request.getCookies()){
            sb.append("cookie:");
            sb.append(cookie.getName());
        }
        return sb.toString();
    }


}
