package com.sjh.test;

import com.sjh.utils.Cal;
import com.sjh.utils.MyInvocationHandler;
import com.sjh.utils.impl.CalImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {

    @Test
    public void testCal1(){
        Cal cal = new CalImpl();
        cal.add(1,1);
        cal.sub(2,2);
        cal.mul(3,3);
        cal.div(4,4);
    }

    @Test
    public void testCal2(){
        Cal cal = new CalImpl();
        Cal proxy = (Cal) new MyInvocationHandler().getProxy(cal);
        proxy.add(1,1);
        proxy.sub(2,2);
        proxy.mul(3,3);
        proxy.div(4,4);
    }

    @Test
    public void testCal3(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("aop.xml");
        Cal proxy = (Cal) ac.getBean("calImpl");//name使用被代理类的类名首字母小写形式
        proxy.add(1,1);
        proxy.sub(2,2);
        proxy.mul(3,3);
        proxy.div(4,4);
    }
}
