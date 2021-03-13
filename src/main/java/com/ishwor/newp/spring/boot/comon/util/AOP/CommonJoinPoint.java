package com.ishwor.newp.spring.boot.comon.util.AOP;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPoint {
	
	@Pointcut("execution(* com.ishwor.newp.spring.boot.controller.*.*.*(..))")
	public void dataLayerExecution() {}
	
	@Pointcut("@annotation(com.ishwor.newp.spring.boot.comon.util.AOP.TrackQueryTime)")
	public void TrackQueryTimeAnnotation() {
		
	}
}
