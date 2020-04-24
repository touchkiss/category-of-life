package com.touchkiss.categoryoflife.es.annotations;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created on 2020/03/24 17:18
 * 计时器
 *
 * @author Touchkiss
 */
@Component
@Aspect
public class TimerAop {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around(value = "@annotation(com.touchkiss.categoryoflife.es.annotations.Timer)")
    public Object timer(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object proceed = proceedingJoinPoint.proceed();
        String functionName;
        Method method = ((MethodSignature) (proceedingJoinPoint.getSignature())).getMethod();
        Timer timer = method.getAnnotation(Timer.class);
        if (StringUtils.isNotBlank(timer.value())) {
            functionName = timer.value();
        } else {
            functionName = proceedingJoinPoint.getTarget().getClass().getName() + ">>" + proceedingJoinPoint.getSignature().getName() + "()";
        }
        logger.info("============" + functionName + "==执行时间：" + (System.currentTimeMillis() - startTime) + "毫秒==========");
        return proceed;
    }
}
