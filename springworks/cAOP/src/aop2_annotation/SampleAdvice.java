package aop2_annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SampleAdvice {
	@Around("execution(public * aop2_annotation.*.*Hello(..))")
 public Object around(ProceedingJoinPoint point) throws Throwable
 {
	 String MethodName = point.getSignature().getName();
	 System.out.println("-------------[사전작업]------------------" +MethodName);
	 Object obj = point.proceed();
	 System.out.println("-------------[사후작업]------------------" +MethodName);
	 return obj;
 }
}
