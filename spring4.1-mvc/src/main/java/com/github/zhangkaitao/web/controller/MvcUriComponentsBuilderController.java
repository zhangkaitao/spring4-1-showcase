package com.github.zhangkaitao.web.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

/**
 * User: zhangkaitao
 * Date: 14-8-6
 * Time: ÉÏÎç8:54
 * Version: 1.0
 */
@RestController
public class MvcUriComponentsBuilderController {

    @RequestMapping("/uri")
    public String mvcUriComponentsBuilder1() {
        return MvcUriComponentsBuilder.fromMappingName("MUCBC#mvcUriComponentsBuilder1").build();
    }


    @RequestMapping("/uri/{id}")
    public String mvcUriComponentsBuilder2(@PathVariable Long id) {
        return MvcUriComponentsBuilder.fromMappingName("MUCBC#mvcUriComponentsBuilder2").arg(0, "123").build();
    }


}
