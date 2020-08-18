package sample2;

public class MainApp {

	public static void main(String[] args) {
		MessageBean bean=new English();
		bean.sayHello("홍길동");
		bean=new Korean();
		bean.sayHello("홍길동");
		
	}

}
