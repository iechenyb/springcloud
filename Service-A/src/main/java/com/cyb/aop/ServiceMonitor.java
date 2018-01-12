package com.cyb.aop;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.stereotype.Component;
/**
 *作者 : iechenyb<br>
 *类描述: 统计服务调用次数<br>
 *创建时间: 2018年1月11日
 */
@Aspect
@Component
public class ServiceMonitor {
	 Log log = LogFactory.getLog(ServiceMonitor.class);
	
	 @Autowired
	 private CounterService counterService;
	 
	 @Autowired
	 private GaugeService gaugeService;
	 
	 @Before("execution(* com.cyb.web.controller.*.*(..))")
	 public void countServiceInvoke(JoinPoint joinPoint) {
		 System.out.println(joinPoint.getSignature().getName()+"服务被调用！");
	     counterService.increment(joinPoint.getSignature().getName());
	 }
	 
	 @Around("execution(* com.cyb.web.controller.*.*(..))")
	 public Object latencyService(ProceedingJoinPoint pjp) throws Throwable {
	  long start = System.currentTimeMillis();
	  Object obj = pjp.proceed();
	  long end = System.currentTimeMillis();
	  gaugeService.submit(pjp.getSignature().toString(), end - start);
	  return obj;
	 }
}
