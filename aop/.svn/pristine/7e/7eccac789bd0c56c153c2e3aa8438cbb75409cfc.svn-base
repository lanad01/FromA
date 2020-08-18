package sample2;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class BeforeMyAdvice implements MethodBeforeAdvice {

	public void before(Method method, Object[] args, Object target) throws Throwable {
		String methodName = method.getName();//타겟의 메서드 이름
		System.out.println("Before 어드바이스, 메서드 이름:"+methodName);
	}

}
