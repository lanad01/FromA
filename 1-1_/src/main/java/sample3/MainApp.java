package sample3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String [] args) {
		// 스프링 환경설정 파일을 연다.
		ApplicationContext ctx=new ClassPathXmlApplicationContext("sample3/beans.xml"); // 환경설정파일이름
		MessageBean bean=(MessageBean)ctx.getBean("messageBeanKR"); //분기 id 
		//이것이 바로 Dependency Injection이다 
		bean.sayHello("홍길동");
	}
}
