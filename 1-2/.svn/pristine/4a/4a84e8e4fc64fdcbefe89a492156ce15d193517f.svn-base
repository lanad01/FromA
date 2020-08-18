package sample1;

import java.io.IOException;

public class MessageBeanImpl implements MessageBean {
	private String name;//생성자를 통한 주입
	private String greeting;//세터를 통한 주입
	private Outputter outputter;//세터를 통한 주입
	
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
	}
	public MessageBeanImpl(String name) {this.name = name;}//생성자
	@Override
	public void sayHello() {
		String message = greeting + name + "~";
		try {
			outputter.output(message);//인사말+이름+~ 가 파일로 출력
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}

















