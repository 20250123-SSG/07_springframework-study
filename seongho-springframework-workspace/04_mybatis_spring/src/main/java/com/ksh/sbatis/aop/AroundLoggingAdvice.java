package com.ksh.sbatis.aop;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;
import java.util.Map;

@Slf4j
@Component
@Aspect
public class AroundLoggingAdvice {

    @Around("execution (* com.ksh.sbatis.controller.*Controller.*(..))")
    public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{

        //핵심로직 메소드 실행전
        //요청 파라미터 출력
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();

        Map<String, String[]> map = request.getParameterMap();

        String params = "";
        if(map.isEmpty()){
            params += "no parameter";
        }else {
                    for(String key: map.keySet()){
                        String[] value = map.get(key);
                        params += key + ":" + Arrays.toString(value) + " ";
                    }
        }
        log.debug("{}", "┬".repeat(70));
        log.debug("{} │ {}", request.getMethod(), request.getRequestURI());
        log.debug("{}", params);
        Object obj = proceedingJoinPoint.proceed();

        //실행되고 나서
        log.debug("{}", "┴".repeat(70));
        return obj;

    }

}
