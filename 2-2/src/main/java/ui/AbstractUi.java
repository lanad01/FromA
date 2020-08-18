package ui;

import java.util.Scanner;

public abstract class AbstractUi {
	protected String getInputedString() {//화면에서 문자열을 입력받는 기능
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();//입력받은 문자열을 리턴
	}
	abstract public void show();//추상 메서드(몸통이 없는 메서드)
}
