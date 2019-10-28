package com.change.le.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * author shichangle
 * date 2019/10/28 0028 9:37
 */
@Controller
public class AdminController {

    @GetMapping("/admin/center")
    public String adminCenterPage() {
        return "admin/center";
    }

    @GetMapping("/admin/welcome")
    public String adminWelcome(){
        return "/admin/welcome";
    }
}
