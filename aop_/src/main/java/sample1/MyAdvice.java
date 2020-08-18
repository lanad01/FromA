package sample1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class MyAdvice implements MethodInterceptor {//Around Advice 앞뒤로 실행된다
	public Object invoke(MethodInvocation invocation) throws Throwable { //Callback 메소드
		StopWatch sw=new StopWatch();//초시계 생성
		String methodName=invocation.getMethod().getName();
		sw.start(methodName);
		System.out.println("어드바이스 실행 됨, 메소드 이름 :"+methodName);
		Object obj=invocation.proceed();//원래의 프로그램 실행 
		sw.stop();//초시계중지
		System.out.println("어드바이스 실행됨, 메서드 실행시간:"+sw.getTotalTimeMillis()/1000);
		
		return obj;
	}

}
