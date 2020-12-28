package com.brent.demo.common.basecontroller;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

@Slf4j
@Aspect
@Component
public class ResBodyAop {

    private static Integer SUCCESS_STATE = 0;
    private static Integer FAIL_STATE = 1;

    @Pointcut("execution(public * com.brent.demo.controller..*.*(..))")
    private void controllerMethod(){};

    @Around("controllerMethod()")
    public Object aroundMethod(ProceedingJoinPoint pjd){
        ResBody resBody = null;
        Object result = null;
        String methodName = pjd.getSignature().getName();
        try {
            //前置通知
            log.info("The method " + methodName + " begins with " + Arrays.asList(pjd.getArgs()));
            //执行目标方法
            result = pjd.proceed();
            if(Objects.nonNull(result)){
                if(result.getClass().isInstance(ResBody.class)){
                    resBody = (ResBody)result;
                }
                resBody = new ResBody();
                resBody.setState(ResBodyAop.SUCCESS_STATE);
                resBody.setData(result);
            }else {
                resBody = new ResBody();
                resBody.setState(ResBodyAop.SUCCESS_STATE);
            }
            //返回通知
            log.debug("The method " + methodName + " ends with " + result);
        } catch (Throwable e) {
            resBody = new ResBody();
            resBody.setState(ResBodyAop.FAIL_STATE);
            resBody.setMsg(e.getMessage());
            //异常通知
            log.error("The method " + methodName + " occurs exception:" + e.getMessage(),e);
        }
        //后置通知
        log.debug("The method " + methodName + " ends");

        return resBody;
    }
}


