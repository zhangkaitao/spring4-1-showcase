package com.github.zhangkaitao.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.zhangkaitao.web.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: zhangkaitao
 * Date: 14-8-4
 * Time: 下午2:22
 * Version: 1.0
 */
@Controller
public class MyViewController {

    @RequestMapping("/velocity/view1")
    public String velocityView1() {
        return "view1";
    }

    @RequestMapping("/velocity/view2")
    public String velocityView2() {
        return "web/controller/view2";
    }

    @RequestMapping("/json")
    public User user() {//默认视图解析器解析
        return new User(1L, "zhangsan");
    }


}
