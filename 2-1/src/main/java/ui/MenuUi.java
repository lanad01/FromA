package ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MenuUi extends AbstractUiTeamplate {
	private SelectTeamUi selectTeamUi;
	
	public void setSelectTeamUi(SelectTeamUi selectTeamUi) {
		this.selectTeamUi = selectTeamUi;
	}
	protected void showMenu() {
		System.out.println("***야구 팀 관리 시스템***");
		System.out.println("*                       *");
		System.out.println("* 1.종료                *");
		System.out.println("* 2.팀 목록 보기         *");
		System.out.println("*                        *");
		System.out.println("번호를 입력한 후 Enter를 누르세요.");
	}
	protected int getMaxMenuNumber() {	return 2;	}
	protected int getMinMenuNumber() {	return 1;	}
	protected void execute(int number) {
		switch(number) {
		case 1: System.out.println("시스템이 종료되었습니다.");
				System.exit(0);
				break;
		case 2: //야구팀 목록을 보여주는 기능
				selectTeamUi.show();
		}
	}

	public static void main(String[] args) {
		//스프링 환경설정 파일을 연다.
		//환경설정 화일에 선언된 종속객체를 불러온다.
		//메서드를 호출한다.
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext("beans.xml");
		MenuUi menuUi = (MenuUi)ctx.getBean("menuUi");
		while(true) {
			menuUi.show();
		}
	}
}
























