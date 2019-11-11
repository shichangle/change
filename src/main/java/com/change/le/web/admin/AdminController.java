package com.change.le.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * author shichangle
 * date 2019/10/28 0028 9:37
 */
@Controller
public class AdminController {

    @GetMapping("/admin/cen")
    public String adminCenterPage() {
        return "admin/center";
    }

    @GetMapping("/admin/wel")
    public String adminWelcome(){
        return "/admin/welcome";
    }

    /**
     * 管理员登录页
     * @return
     */
    @GetMapping("/admin/login")
    public String adminLoginPage() {
        return "/admin/login1";
    }
}
