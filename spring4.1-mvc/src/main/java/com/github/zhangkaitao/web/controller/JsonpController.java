package com.github.zhangkaitao.web.controller;

import com.github.zhangkaitao.web.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.naming.ldap.Control;

/**
 * User: zhangkaitao
 * Date: 14-8-4
 * Time: 下午8:32
 * Version: 1.0
 */

@Controller
public class JsonpController {

    @RequestMapping("/jsonp1")
    public User jsonp1() {//没有@ResponseBody 直接走MappingJackson2JsonView
        return new User(1L, "zhangsan");
    }


    @RequestMapping("/jsonp2")
    @ResponseBody
    public User jsonp2() {
        return new User(1L, "zhangsan");
    }

}
