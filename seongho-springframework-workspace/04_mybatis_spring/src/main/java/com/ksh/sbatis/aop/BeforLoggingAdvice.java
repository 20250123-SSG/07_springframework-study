package com.ksh.sbatis.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect

public class BeforLoggingAdvice {

    //포인트 커엇
    @Pointcut("execution (* com.ksh.sbatis.controller.*Controller.*(..))")
    public void setPointCut(){

    }

    //실행시킬 Advice 메소드
    @Before("setPointCut()")
    public void myBeforAdvice(JoinPoint joinPoint){
    log.debug("((((((beforeLoggingAdvice 실행크))))))))))))))))");

    Object[] args = joinPoint.getArgs();
    for (Object arg : args){
        log.debug("arg's type: {}, value: {}", arg.getClass().getSimpleName(),arg);
    }

    Signature signature = joinPoint.getSignature();
    log.debug("method : {}", signature.getName());
    log.debug("short method: {}", signature.toShortString());
    log.debug("long method{}", signature.toLongString());
    }
}
