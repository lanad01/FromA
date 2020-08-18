package ui;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public abstract class AbstractUiTemplate extends AbstractUi {
	abstract protected void showMenu();
	abstract protected int getMaxMenuNumber();
	abstract protected int getMinMenuNumber();
	abstract protected void execute(int number);
	protected boolean isValidNumber(String str) {
		if(StringUtils.isBlank(str)) { return false; } // 스프링에만 있는 클래스 StringUtils~
		if(!StringUtils.isNumeric(str)) { return false;}
		int number=NumberUtils.toInt(str); // str 정수로 캐스팅
		if(getMinMenuNumber() <= number && number <= getMaxMenuNumber()) {
		return true;
		}
		return false;
	}
	public void show() { //Overriding
		showMenu();
		String inputedString=this.getInputedString();//입력받는다 // 조상클래스 AbstractUi가 가지고 있다
		if(isValidNumber(inputedString)) { // isValid메서드에서 true가 출력된다?
			execute(NumberUtils.toInt(inputedString));//메뉴를 실행한다 int로 캐스팅해서 ㅎㅎ
		}
	}
}
