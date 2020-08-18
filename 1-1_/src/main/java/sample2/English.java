package sample2;

public class English implements MessageBean {

	
	@Override
	public void sayHello(String name) {
		System.out.println("Nice to meet,"+name);
	}

}
