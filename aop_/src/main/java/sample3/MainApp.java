package sample3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		//스프링 환경설정 파일을 연다
		ApplicationContext ctx=new ClassPathXmlApplicationContext("sample3/beans.xml");
		//생성된 종속객체를 불러온다.
		MessageBean bean=(MessageBean)ctx.getBean("proxy"); // Around 로 실행되기 때문에 앞뒤로 나옴
		//실행한다
		bean.sayHello();
	}
}
