package sample1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class MyAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		StopWatch sw = new StopWatch();//초시계 생성
		String methodName = invocation.getMethod().getName();//메서드이름
		sw.start(methodName);//초시계 시작
		System.out.println("어드바이스 실행됨, 메서드 이름:"+methodName);
		Object obj = invocation.proceed();//원래의 프로그램 실행
		sw.stop();//초시계 중지
		System.out.println("어드바이스 실행됨, 메서드 실행 시간:"+
				sw.getTotalTimeMillis()/1000);
		return obj;
	}

}

















