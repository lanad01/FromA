package ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MenuUi extends AbstractUiTemplate {
	private SelectTeamUi selectTeamUi;
	public void setSelectTeamUi(SelectTeamUi selectTeamUi) {
		this.selectTeamUi=selectTeamUi;
	}
	protected void showMenu() {
		System.out.println("야구팀 관리 시스템");
		System.out.println("*         *");
		System.out.println("1.종료            *");
		System.out.println("2.팀목록보기   *");
		System.out.println("*         *");
		System.out.println("번호를 입력 후 Enter를 누르세요.");
	}
	protected int getMaxMenuNumber() {return 2;}
	protected int getMinMenuNumber() {return 1;}
	protected void execute(int number) {
		switch(number) {
		case 1: System.out.println("시스템 종료됨");
				System.exit(0); // 강제종료
		case 2: //야구팀목록을 보여주는 기능
				selectTeamUi.show();
		}

	}
	public static void main(String[] args) {
		//스프링 환경설정 파일 열기
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		// 선언된 종속객체 불러오기
		MenuUi menuUi=(MenuUi)ctx.getBean("menuUi");
		//메소드 실행
		while(true) {
			menuUi.show();
		}
		
	}

}
