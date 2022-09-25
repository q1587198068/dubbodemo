package com.athy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/th")
public class ThymleafController {

    @RequestMapping("/gotoThym")
    public String gotoThym(Model model) {
//thymleaf模板直接访问tempkates下的HTML
        model.addAttribute("user_name", "zhangsansan");
        return "test";
    }

    @RequestMapping("/aa")
    @ResponseBody
    public String aa() {

        return "aa";
    }
}
