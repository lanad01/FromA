package sample3;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class AfterMyAdvice implements AfterReturningAdvice {

	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		String methodName=method.getName();
		System.out.println("After 어드바이스, 메서드 이름:"+methodName);
	}

}
