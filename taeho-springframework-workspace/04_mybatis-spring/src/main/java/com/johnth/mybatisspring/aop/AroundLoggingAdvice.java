package com.johnth.mybatisspring.aop;


import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;
import java.util.Map;

@Slf4j
@Component
@Aspect
public class AroundLoggingAdvice {

    @Around("execution (* com.ino.mybatisspring.controller.*Controller.*(..))")
    public Object myAroundAdvice(ProceedingJoinPoint prjp) throws Throwable {

        // before logic method
        // Get HttpServletRequset Object
        HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        Map<String, String[]> parameterMap = req.getParameterMap();
        if(parameterMap.isEmpty()) {
            log.debug("No Param");
        }else{
            for ( String key : parameterMap.keySet()){
                log.debug("key: " + key);
                log.debug("value : " + Arrays.toString(parameterMap.get(key)));
            }
        }
        log.debug("{} | {}", req.getMethod(), req.getRequestURI());

        // run logic method, mandatory
        Object obj = prjp.proceed();

        // after logic method
        log.debug("after run logic");

        return obj;
    }
}