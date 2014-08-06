package com.github.zhangkaitao.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.zhangkaitao.web.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: zhangkaitao
 * Date: 14-8-4
 * Time: 下午2:50
 * Version: 1.0
 */
@RestController
public class JacksonJsonViewController {

    @RequestMapping("/jackson1")
    @JsonView(User.OnlyIdView.class)
    public User test1() {
        return new User(1L, "zhangsan");
    }


    @RequestMapping("/jackson2")
    @JsonView(User.OnlyNameView.class)
    public User test2() {
        return new User(1L, "zhangsan");
    }

    @RequestMapping("/jackson3")
    @JsonView(User.AllView.class) //可以省略
    public User test3() {
        return new User(1L, "zhangsan");
    }
}
