package sample2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		//스프링 환경설정파일을 연다.
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext("sample2/beans.xml");
		KimChangMin kim = (KimChangMin)ctx.getBean("kimChangMin");
		kim.has();
	}

}















