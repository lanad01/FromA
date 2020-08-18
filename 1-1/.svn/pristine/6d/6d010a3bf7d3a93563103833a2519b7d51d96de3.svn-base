package sample3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		//스프링 환경설정파일을 연다.
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("sample3/beans.xml");
		MessageBean bean = (MessageBean)ctx.getBean("messageBeanEn");
		bean.sayHello("홍길동");
	}

}

















