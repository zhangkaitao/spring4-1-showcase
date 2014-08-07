package com.github.zhangkaitao.proto;

import com.github.zhangkaitao.pb.UserProtos;
import com.github.zhangkaitao.web.controller.MyExtensionRegistryInitializer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.protobuf.ExtensionRegistryInitializer;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
* User: zhangkaitao
* Date: 14-8-5
* Time: 上午8:48
* Version: 1.0
*/
public class ProtoTest {

    static RestTemplate restTemplate;
    String baseUri = "http://localhost:8080/";

    private static Server server;

    @BeforeClass
    public static void beforeClass() throws Exception {
        //创建一个server
        server = new Server(8080);
        WebAppContext context = new WebAppContext();
        String webapp = "spring4.1-mvc/src/main/webapp";
        context.setDescriptor(webapp + "/WEB-INF/web.xml");  //指定web.xml配置文件
        context.setResourceBase(webapp);  //指定webapp目录
        context.setContextPath("/");
        context.setParentLoaderPriority(true);

        server.setHandler(context);
        server.start();
        restTemplate = new RestTemplate();
        ExtensionRegistryInitializer extensionRegistryInitializer = new MyExtensionRegistryInitializer();
        ProtobufHttpMessageConverter protobufHttpMessageConverter =
                new ProtobufHttpMessageConverter(extensionRegistryInitializer);
        restTemplate.getMessageConverters().add(0, protobufHttpMessageConverter);
    }

    @AfterClass
    public static void afterClass() throws Exception {
        server.stop(); //当测试结束时停止服务器
    }


    @Test
    public void testRead() {
        HttpHeaders headers = new HttpHeaders();
        RequestEntity<UserProtos.User> requestEntity =
                new RequestEntity<UserProtos.User>(headers, HttpMethod.POST, URI.create(baseUri + "/proto/read"));

        ResponseEntity<UserProtos.User> responseEntity =
                restTemplate.exchange(requestEntity, UserProtos.User.class);

        System.out.println(responseEntity.getBody());
    }

    @Test
    public void testWrite() {
        UserProtos.User user = UserProtos.User.newBuilder().setId(1).setName("zhangsan").build();
        HttpHeaders headers = new HttpHeaders();
        RequestEntity<UserProtos.User> requestEntity =
                new RequestEntity<UserProtos.User>(user, headers, HttpMethod.POST, URI.create(baseUri + "/proto/write"));

        ResponseEntity<UserProtos.User> responseEntity =
                restTemplate.exchange(requestEntity, UserProtos.User.class);
        System.out.println(responseEntity.getBody());
    }


}
