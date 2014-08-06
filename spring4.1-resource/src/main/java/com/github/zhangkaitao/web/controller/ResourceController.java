package com.github.zhangkaitao.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: zhangkaitao
 * Date: 14-8-6
 * Time: обнГ8:10
 * Version: 1.0
 */
@Controller
public class ResourceController {

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

}
