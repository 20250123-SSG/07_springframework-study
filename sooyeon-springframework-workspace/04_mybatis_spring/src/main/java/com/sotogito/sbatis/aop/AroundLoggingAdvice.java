package com.sotogito.sbatis.aop;

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

    @Around("execution(* com.sotogito.sbatis.controller.*Controller.*(..))")
    public Object myAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        // 핵심 로직 메서드 실행 전
        // 요청 파라미터, 요청 방식, 요청 URI 출력
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        Map<String, String[]> map = request.getParameterMap();

        StringBuilder params = new StringBuilder();
        if (map.isEmpty()) {
            params.append("No Parameter");
        } else {
            map.forEach((key, value) -> {
                params.append(key)
                      .append("=")
                      .append(Arrays.toString(value))
                      .append("  ");
            });
        }

        log.debug("{}", "@".repeat(70));
        log.debug("{} | {}", request.getMethod(), request.getRequestURI());
        log.debug("Parameters: {}", params.toString());

        // 핵심 로직 메서드를 실행
        Object obj = joinPoint.proceed();

        // 핵심 로직 메서드 실행 후
        log.debug("{}", "@".repeat(70));

        // 핵심 로직 메서드의 실행 결과 반환
        return obj;
    }
}
