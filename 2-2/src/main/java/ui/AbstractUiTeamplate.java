package ui;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public abstract class AbstractUiTeamplate extends AbstractUi {
	abstract protected void showMenu();
	abstract protected int getMaxMenuNumber();
	abstract protected int getMinMenuNumber();
	abstract protected void execute(int number);
	protected boolean isValidNumber(String str) {//유효한 메뉴인지 검사
		if(StringUtils.isBlank(str)) {return false;	}
		if( ! StringUtils.isNumeric(str)) {return false;}
		int number=NumberUtils.toInt(str);//str에 있는 문자열을 정수로 바꿈
		if(getMinMenuNumber() <= number && number <= getMaxMenuNumber()) {
			return true;
		}
		return false;
	}
	public void show() {
		showMenu();//메뉴를 출력한다.
		String inputedString = this.getInputedString();//입력받는다.
		if(isValidNumber(inputedString)) {//입력받은 메뉴가 유효한 경우
			execute(NumberUtils.toInt(inputedString));//메뉴를 실행한다.
		}
	}

}














