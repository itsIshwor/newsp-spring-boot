package com.ishwor.newp.spring.boot.comon.util.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Aspect
@Configuration
@Component
public class QueryMonitor {

	private static final Logger log = LoggerFactory.getLogger(QueryMonitor.class);

	@Before("com.ishwor.newp.spring.boot.comon.util.AOP.CommonJoinPoint.dataLayerExecution()")
	public void beforeQuery(JoinPoint joinpoint) {
		log.info("\n\n\nNew query in request method on ::: {}\n\n\n", joinpoint);
	}

	@Around("com.ishwor.newp.spring.boot.comon.util.AOP.CommonJoinPoint.TrackQueryTimeAnnotation()")
	public Object totalTimeTaken(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();

		Object returnValue = joinPoint.proceed();

		long endtime = System.currentTimeMillis();

		log.info(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName()
				+ "\n\nTime taken for Execution is : " + ((endtime - startTime) / 1000.0) + "sec");
		return returnValue;
	}

	@After("com.ishwor.newp.spring.boot.comon.util.AOP.CommonJoinPoint.dataLayerExecution()")
	public void afterQuery(JoinPoint joinPoint) {
		log.info("\n\n\nQuery Execution completed on::: {}\n\n\n", joinPoint );
	}
}
