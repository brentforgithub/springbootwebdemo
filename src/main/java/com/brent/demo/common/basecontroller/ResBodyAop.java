package com.brent.demo.common.basecontroller;

import com.brent.demo.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
public class ResBodyAop {

    @Pointcut("execution(public * com.brent.demo.controller..*.*(..))")
    private void controllerMethod(){};

    @Around("controllerMethod()")
    public Object disposeOfException(ProceedingJoinPoint pjd) throws Throwable {
        Object result = null;
        try {
            result = pjd.proceed();
        } catch (Throwable e) {
            if( e instanceof BusinessException && isEquals(pjd)){
                ResBody resBody = new ResBody();
                resBody.setState(((BusinessException) e).getState());
                resBody.setMsg(e.getMessage());
                result = resBody;
            }else {
                log.error("ResBodyAop:disposeOfException",e);
                throw e;
            }
        }
        return result;
    }

    /**
     * 判断返回值类型
     * @param pjd
     * @return
     */
    private boolean isEquals(ProceedingJoinPoint pjd) {
        Method method = ((MethodSignature)pjd.getSignature()).getMethod();
        return method.getReturnType().getName().equals(ResBody.class.getName());
    }
}


