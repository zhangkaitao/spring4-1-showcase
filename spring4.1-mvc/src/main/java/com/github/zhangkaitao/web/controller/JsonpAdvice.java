package com.github.zhangkaitao.web.controller;

import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

import java.util.Arrays;
import java.util.Collection;

/**
 * User: zhangkaitao
 * Date: 14-8-4
 * Time: обнГ8:34
 * Version: 1.0
 */
@Order(2)
@ControllerAdvice(basePackages = "com.github")
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {

    public JsonpAdvice() {
        super("callback");
    }
}
