package com.github.zhangkaitao.web.controller;

import com.github.zhangkaitao.pb.UserProtos;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* User: zhangkaitao
* Date: 14-8-5
* Time: ÉÏÎç8:40
* Version: 1.0
*/
@RestController
public class ProtobufController {

    @RequestMapping("/proto/read")
    public ResponseEntity<UserProtos.User> protoRead() {
        return ResponseEntity.ok(UserProtos.User.newBuilder().setId(1).setName("zhangsan").build());
    }


    @RequestMapping("/proto/write")
    public ResponseEntity<UserProtos.User> protoRead(RequestEntity<UserProtos.User> requestEntity) {
        System.out.println("server===\n" + requestEntity.getBody());
        return ResponseEntity.ok(requestEntity.getBody());
    }
}
