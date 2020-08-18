package ui;

import java.util.Scanner;

public abstract class AbstractUi {
	protected String getInputedString() {
		Scanner scan=new Scanner(System.in);
		return scan.nextLine(); //입력받은 문자열을 리턴
	}
	abstract public void show(); //추상메서드 몸통이 없는 메서드
}
