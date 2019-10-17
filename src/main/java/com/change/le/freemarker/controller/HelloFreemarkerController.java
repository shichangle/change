package com.change.le.freemarker.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


@Controller
@RequestMapping("/freemarker")
public class HelloFreemarkerController {
    private static Logger log = LoggerFactory.getLogger(HelloFreemarkerController.class);


    @RequestMapping("/helloFreemarker")
    public String hello(Map<String,Object> map){
        log.info("跳转freemarker页面");
        map.put("name","zhangsandege");
        return "freemarkerTest";
    }
}
