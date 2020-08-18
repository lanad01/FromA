package sample1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		//스프링 환경설정 파일을 연다
		ApplicationContext ctx=new ClassPathXmlApplicationContext("sample1/beans.xml");
		MessageBean bean=(MessageBean)ctx.getBean("messageBean");
		bean.sayHello();
	}

}
