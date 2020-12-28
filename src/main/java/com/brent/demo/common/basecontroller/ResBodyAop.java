package com.brent.demo.common.basecontroller;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

@Slf4j
@Aspect
@Component
public class ResBodyAop {

    @Pointcut("execution(public * com.brent.demo.controller..*.*(..))")
    private void controllerMethod(){};

    @Around("controllerMethod()")
    public Object aroundMethod(ProceedingJoinPoint pjd) throws Throwable {
        Object result = null;
        String methodName = pjd.getSignature().getName();


        try {
            //执行目标方法
            result = pjd.proceed();
        } catch (Throwable e) {
            Method method = ((MethodSignature)pjd.getSignature()).getMethod();
            if(method.getReturnType().getName().equals(ResBody.class.getName())){
                ResBody resBody = new ResBody();
                resBody.setState(BaseC.FAIL_STATE);
                resBody.setMsg(e.getMessage());
                result = resBody;
            }else {
                throw e;
            }
        }
        return result;
    }
}


