package com.github.zhangkaitao.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: zhangkaitao
 * Date: 14-8-7
 * Time: ионГ8:53
 * Version: 1.0
 */
@Controller
public class TestController {

    @RequestMapping("/test")
    public String test(Model model) {
        model.addAttribute("message", "hello");
        return "test";
    }
}
