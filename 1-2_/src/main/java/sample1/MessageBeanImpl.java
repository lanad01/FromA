package sample1;

import java.io.IOException;

public class MessageBeanImpl implements MessageBean {// 종속객체
	private String name;//생성자를 통한 문자열 주입
	private String greeting; //Setter를 통한 문자열 주입
	private OutPutter outputter; //Setter를 통한 객체 주입
	public MessageBeanImpl(String name) {
		this.name=name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setOutputter(OutPutter outputter) {
		this.outputter = outputter;
	}
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	@Override
	public void sayHello() {
		String message=greeting+name+"~";
		try {
			outputter.output(message); // 인사말, 이름,  ~
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
