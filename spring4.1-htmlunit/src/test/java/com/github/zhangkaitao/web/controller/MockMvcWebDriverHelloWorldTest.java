package com.github.zhangkaitao.web.controller;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.DirectFieldAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebConnection;
import org.springframework.test.web.servlet.htmlunit.webdriver.MockMvcHtmlUnitDriver;
import org.springframework.test.web.servlet.request.RequestPostProcessor;
import org.springframework.test.web.servlet.setup.ConfigurableMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcConfigurer;
import org.springframework.util.ClassUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


/**
 * User: zhangkaitao
 * Date: 14-8-8
 * Time: ÉÏÎç7:43
 * Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring-mvc.xml")
@WebAppConfiguration(value = "spring4.1-htmlunit/src/main/webapp")
public class MockMvcWebDriverHelloWorldTest {
    @Autowired
    private WebApplicationContext context;

    MockMvc mockMvc;
    MockMvcHtmlUnitDriver webDriver;


    @Before
    public void setup() throws Exception {
        mockMvc = webAppContextSetup(context).build();
        boolean enableJavascript = true;
        String contextPath = "";
        webDriver = new MockMvcHtmlUnitDriver(mockMvc, enableJavascript);
        DirectFieldAccessor accessor = new DirectFieldAccessor(webDriver);
        BeanWrapper wrapper = new BeanWrapperImpl(accessor.getPropertyValue("webClient"));
        wrapper.setPropertyValue("webConnection", new MockMvcWebConnection(mockMvc, contextPath));
    }

    @After
    public void tearDown() {
        webDriver.close();
    }

    @Test
    public void test() throws Exception {

        webDriver.get("http://localhost/test1");
        WebElement form1 = webDriver.findElement(By.id("form"));
        webDriver.findElement(By.id("id")).sendKeys("1");
        webDriver.findElement(By.id("name")).sendKeys("lisi");
        form1.findElement(By.cssSelector("input[type=submit]")).click();

        assertEquals("http://localhost/test2", webDriver.getCurrentUrl());

        assertEquals("1", webDriver.findElementById("id").getAttribute("value"));
        assertEquals("lisi", webDriver.findElementById("name").getAttribute("value"));

        webDriver.findElementByCssSelector("#form input[type=submit]").click();

        assertEquals("/submit", webDriver.findElementById("form").getAttribute("action"));
        assertEquals("123", webDriver.findElementById("id").getAttribute("value"));
        assertEquals("zhangsan", webDriver.findElementById("name").getAttribute("value"));



    }

}
