package ui;

import java.util.List;

import dao.TeamDao;
import model.Team;

public class SelectTeamUi extends AbstractUi{
	private TeamDao teamDao;
	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}
	protected void showTeamList(List<Team> list) {
		System.out.println("-------");
		System.out.println("팀번호 팀이름");
		for(Team team:list) {
			System.out.printf("%d %s\n", team.getTeam_id(), team.getTeam_name());
		}
	}
	public void show() {
		showTeamList(this.teamDao.getTeamList()); //DB에서 조회합니다
		System.out.println("엔터를 누르세요");
		this.getInputedString();//화면에서 입력받는다
	}	
	

}
