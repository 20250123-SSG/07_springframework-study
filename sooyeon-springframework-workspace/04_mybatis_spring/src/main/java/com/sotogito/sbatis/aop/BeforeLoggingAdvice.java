package com.sotogito.sbatis.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/// 모든 컨트롤러측의 모든 메서드가 동작되기 전에 로그 출력

@Slf4j
//@Component
@Aspect
public class BeforeLoggingAdvice {

    /// 포인트컷 표현식과 포인트컷 서명을 분리하는 방법
    /// 포인트컷
    @Pointcut("execution(* com.sotogito.sbatis.controller.*Controller.*(..))")
    public void setPointCut() {

    }


    /// 실행시킬 Advice 메서드 (공통로직)
    @Before("setPointCut()") //컨트롤러 메서드가 동작하기전에 동작하는 메서드
    public void myBeforeAdvice(JoinPoint joinPoint) {
        log.debug("Before Advice ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~sdfasdfewdvwegggwgwgwegwegegweg~~~~~~");

        Object[] args = joinPoint.getArgs(); ///핵심로직메서드로 전달된 인자값(배열) 반환
        for(Object arg : args) {
            log.debug("arg type = {}", args.getClass().getSimpleName());
            log.debug("value = {}", arg);
        }

        Signature signature = joinPoint.getSignature();
        log.debug("method = {}", signature.getName());
        log.debug("short method = {}", signature.toShortString()); //클래스명.메서드명
        log.debug("long method = {}", signature.toLongString());
    }

}
