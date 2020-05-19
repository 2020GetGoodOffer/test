package com.sjh.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggerAspect {

    @Pointcut("execution(*  *..CalImpl.*(int,int))")
    private void pc(){}
//
//    @Before("pc()")
//    public void before(JoinPoint joinPoint){
//        //获取方法名
//        String methodName = joinPoint.getSignature().getName();
//        //获取参数
//        String args = Arrays.toString(joinPoint.getArgs());
//        System.out.println(methodName+"方法的参数是："+ args);
//    }
//
//    @AfterReturning(value = "pc()",returning = "result")
//    public void afterReturning(JoinPoint joinPoint,Object result){
//        //获取方法名
//        String methodName = joinPoint.getSignature().getName();
//        System.out.println(methodName+"方法的结果是："+result);
//    }
//
//    @After("pc()")
//    public void after(JoinPoint joinPoint){
//        //获取方法名
//        String methodName = joinPoint.getSignature().getName();
//        System.out.println(methodName+"方法执行完毕");
//    }

    @Around("pc()")
    public Object after(ProceedingJoinPoint pjp){
        Object res;
        String methodName = null;
        try{
            //获取参数
            Object[] args = pjp.getArgs();
            methodName = pjp.getSignature().getName();
            System.out.println(methodName + "方法的参数是：" + Arrays.toString(args));
            //获取方法返回结果
            res = pjp.proceed(args);
            System.out.println(methodName + "方法的执行结果是：" + res);
            return res;
        }catch (Throwable t){
            throw new RuntimeException(t);
        }finally {
            System.out.println(methodName + "方法执行完毕");
            System.out.println("------------------------");
        }
    }

}
