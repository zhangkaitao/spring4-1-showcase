package com.github.zhangkaitao.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.zhangkaitao.web.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: zhangkaitao
 * Date: 14-8-4
 * Time: ÏÂÎç2:58
 * Version: 1.0
 */
@Controller
public class RequestResponseEntityController {

    @RequestMapping(value = "/request", method = RequestMethod.GET)
    public String showForm() {
        return "requestForm";
    }

    @RequestMapping(value = "/request", method = RequestMethod.POST)
    public ResponseEntity request(RequestEntity<User> requestEntity) {
        ResponseEntity<User> responseEntity = ResponseEntity.ok(requestEntity.getBody());
        return responseEntity;

    }

}
