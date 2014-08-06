package com.github.zhangkaitao.web.controller;

import com.github.zhangkaitao.web.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: zhangkaitao
 * Date: 14-8-4
 * Time: обнГ7:54
 * Version: 1.0
 */
@Controller
public class GroovyTemplateController {

    @RequestMapping("/groovy/hello")
    public String groovyTemplate(Model model) {
        model.addAttribute("user", new User(1L, "zhangsan"));
        return "hello";
    }

}
