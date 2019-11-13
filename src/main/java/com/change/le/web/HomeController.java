package com.change.le.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * author shichangle
 * date 2019/11/13 0013 15:08
 */
@Controller
public class HomeController {

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/404")
    public String notFoundError() {
        return "404";
    }

    @GetMapping("/403")
    public String accessError(){
        return "403";
    }

    @GetMapping("/500")
    public String internalError(){
        return "500";
    }

    @GetMapping("/logout/page")
    public String logoutPage(){
        return "logout";
    }
}
