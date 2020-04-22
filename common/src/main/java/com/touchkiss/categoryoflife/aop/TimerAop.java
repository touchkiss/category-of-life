package com.touchkiss.categoryoflife.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created on 2020/03/24 17:18
 *
 * @author Touchkiss
 */
@Component
@Aspect
@Slf4j
public class TimerAop {
    @Around(value = "@annotation(com.touchkiss.categoryoflife.aop.Timer)")
    public Object timer(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object proceed = proceedingJoinPoint.proceed();
        String functionName = proceedingJoinPoint.getTarget().getClass().getName() + ">>" + proceedingJoinPoint.getSignature().getName()+"()";
        log.info("============" + functionName + "==执行时间：" + (System.currentTimeMillis() - startTime) + "毫秒==========");
        return proceed;
    }
}
