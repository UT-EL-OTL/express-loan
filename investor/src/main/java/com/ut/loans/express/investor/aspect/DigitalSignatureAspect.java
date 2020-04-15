package com.ut.loans.express.investor.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DigitalSignatureAspect {

	@Before(value = "execution(* com.ut.loans.express.investor.services.*.*(..)) and args(..)")
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("Before method:" + joinPoint.getSignature());
	}

	@After(value = "execution(* com.ut.loans.express.investor.services.*.*(..)) and args(..)")
	public void afterAdvice(JoinPoint joinPoint) {
		System.out.println("After method:" + joinPoint.getSignature());
	}
}