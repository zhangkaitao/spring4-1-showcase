package com.github.zhangkaitao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.DirectFieldAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * User: zhangkaitao
 * Date: 14-7-31
 * Time: 下午8:00
 * Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-direct-field.xml")
public class DirectFieldTest {
    @Autowired
    private Bean bean;
    @Test
    public void testDirectFieldAccess() { //DirectFieldBindingResult
        //嵌套设置/访问对象字段数据
        DirectFieldAccessor accessor = new DirectFieldAccessor(bean);
        //如果嵌套对象为null，字段创建
        accessor.setAutoGrowNestedPaths(true);
        //设置字段值
        accessor.setPropertyValue("bean2.name", "zhangsan");
        //读取字段值
        System.out.println(accessor.getPropertyValue("bean2.name"));
    }
}
