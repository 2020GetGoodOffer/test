package com.sjh.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class MyInvocationHandler implements InvocationHandler {

    //委托对象，即计算器实现类
    private Object object = null;

    //返回代理对象
    public Object getProxy(Object object){
        this.object = object;
        //动态代理的第一个参数 委托类的类加载器，第二个参数 委托类的接口，代理类必须实现其接口，第三个参数 具体的处理逻辑
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        System.out.println(methodName+"方法的参数是："+ Arrays.toString(args));
        Object res = method.invoke(this.object, args);
        System.out.println(methodName+"方法的结果是："+ res);
        return res;
    }

}
