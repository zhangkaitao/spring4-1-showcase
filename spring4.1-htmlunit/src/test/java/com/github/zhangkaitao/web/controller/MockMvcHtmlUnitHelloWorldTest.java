package com.github.zhangkaitao.web.controller;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.DirectFieldAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebConnection;
import org.springframework.web.context.WebApplicationContext;


import static org.springframework.test.web.client.MockRestServiceServer.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.*;
import static org.junit.Assert.*;


/**
 * User: zhangkaitao
 * Date: 14-8-8
 * Time: ÉÏÎç7:43
 * Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring-mvc.xml")
@WebAppConfiguration(value = "spring4.1-htmlunit/src/main/webapp")
public class MockMvcHtmlUnitHelloWorldTest {
    @Autowired
    private WebApplicationContext context;

    MockMvc mockMvc;
    WebClient webClient;


    @Before
    public void setup() throws Exception {
        mockMvc = webAppContextSetup(context).build();

        String contextPath = "";
        webClient = new WebClient();
        webClient.setWebConnection(new MockMvcWebConnection(mockMvc, contextPath));
    }

    @Test
    public void test() throws Exception {
        HtmlPage page1 = webClient.getPage("http://localhost/test1");
        HtmlForm form1 = page1.getHtmlElementById("form");
        assertEquals("/test2", form1.getAttribute("action"));

        page1.getElementById("id").setAttribute("value", "1");
        page1.getElementById("name").setAttribute("value", "lisi");

        HtmlPage page2 = form1.getElementsByAttribute("input", "type", "submit").get(0).click();
        assertEquals("http://localhost/test2", page2.getUrl().toString());
        assertEquals("1", page2.getElementById("id").getAttribute("value"));
        assertEquals("lisi", page2.getElementById("name").getAttribute("value"));

        HtmlForm form2 = page2.getHtmlElementById("form");
        form2.getElementsByAttribute("input", "type", "submit").get(0).click();

        assertEquals("123", page2.getElementById("id").getAttribute("value"));
        assertEquals("zhangsan", page2.getElementById("name").getAttribute("value"));

    }


}
