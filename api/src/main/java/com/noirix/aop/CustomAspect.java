package com.noirix.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class CustomAspect {
    private static final Logger log = Logger.getLogger(CustomAspect.class);

    @Pointcut("execution(* com.noirix.repository.*.*.*(..))")
    public void aroundRepositoryPointcut() {
    }

    @Around("aroundRepositoryPointcut()")
    public Object logAroundMethods(ProceedingJoinPoint joinPoint) throws Throwable {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        System.out.println(joinPoint.getArgs().length);

        log.info("Method " + joinPoint.getSignature().getName() + " start ");

        Object proceed = joinPoint.proceed();

        stopWatch.stop();

        log.info("Method " + joinPoint.getSignature().getName() + " finished : " + "time : " + stopWatch.getTotalTimeMillis());

        return proceed;

    }

}
