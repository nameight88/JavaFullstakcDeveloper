package aop1_xml;

import org.aspectj.lang.JoinPoint;

public class LoggingAdvice {
 public void before(JoinPoint point) throws Throwable{
	 String methodName = point.getSignature().getName();
	 System.out.println("[************* 사전작업] : "+methodName);
 }
 public void xxxxx(JoinPoint point) throws Throwable{
	 String methodName = point.getSignature().getName();
	 System.out.println("[************* 사후작업] : "+methodName);
 }
}
