package sample2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample1.MessageBean;

public class MainApp {

	public static void main(String[] args) {
		//스프링 환경설정 파일을 연다
				ApplicationContext ctx=new ClassPathXmlApplicationContext("sample2/beans.xml");
				KwonSangwoo k=(KwonSangwoo)ctx.getBean("kwon");
				k.has();

	}

}
