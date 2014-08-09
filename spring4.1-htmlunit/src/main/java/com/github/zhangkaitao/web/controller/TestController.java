package com.github.zhangkaitao.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * User: zhangkaitao
 * Date: 14-8-7
 * Time: ÉÏÎç8:53
 * Version: 1.0
 */
@Controller
public class TestController {

    @RequestMapping("/test1")
    public String test1(Model model) {
        return "test1";
    }

    @RequestMapping("/test2")
    public String test2(@RequestParam Long id, @RequestParam String name, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        return "test2";
    }
}
