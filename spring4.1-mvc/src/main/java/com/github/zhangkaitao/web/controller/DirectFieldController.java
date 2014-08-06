package com.github.zhangkaitao.web.controller;

import com.github.zhangkaitao.web.model.User;
import org.springframework.beans.DirectFieldAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.DataBinder;
import org.springframework.validation.DirectFieldBindingResult;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * User: zhangkaitao
 * Date: 14-8-6
 * Time: 上午8:45
 * Version: 1.0
 */
@RestController
public class DirectFieldController {

    @RequestMapping("/directField")
    public String directFieldInject(MyUser user) {
        System.out.println(user);
        return user.toString();
    }

    @InitBinder
    public void initBinder(DataBinder dataBinder) {
        dataBinder.initDirectFieldAccess();//直接字段访问
    }

    static class MyUser implements Serializable {
        private int id;
        private String name;

        @Override
        public String toString() {
            return "MyUser{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
