package com.johnth.mybatisspring.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
//@Component
//@Aspect
public class BeforeLoggingAdvice {

    // point cut
    @Pointcut("execution (* com.johnth.mybatisspring.controller.*Controller.*(..))")
    public void setPointCut(){}
    // advice method(common logic)

    @Before("setPointCut()")
    public void myBeforeAdvice(JoinPoint joinPoint){
        log.debug("run beforeLoggingAdvice");

        Object[] args = joinPoint.getArgs();
        for(Object obj: args){
            log.debug("arg's type: {}, value: {}", obj.getClass().getSimpleName(), obj);
        }

        Signature signature = joinPoint.getSignature();
        log.debug("method: {}", signature.getName()); // methodName
        log.debug("className.methodName: {}", signature.toShortString()); // classname.methodName
    }
}