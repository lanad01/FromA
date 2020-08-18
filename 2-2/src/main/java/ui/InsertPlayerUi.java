package ui;

import org.apache.commons.lang3.StringUtils;

import dao.PlayerDao;
import dao.TeamDao;
import model.Player;
import model.Team;

public class InsertPlayerUi extends AbstractUi {
	//팀번호로 팀을 검색 기능
	private TeamDao teamDao;
	//검색한 팀번호 선수를 삽입 기능
	private PlayerDao playerDao;
	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}
	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}
	protected void showMenu(String msg) {
		System.out.println("......................");
		System.out.printf("%s 를 입력하고 Enter를 누르세요.\n",msg);
		System.out.println("아무것도 입력하지 않고, Enter를 누르면 "
				+ "메뉴로 돌아갑니다.\n");
	}
	protected void showTeamField(Player player) {
		final String teamId = "팀 번호";
		showMenu(teamId);
		String id = this.getInputedString();//화면에서 입력을 받는다.
		if(StringUtils.isEmpty(id)) {//아무것도 없으면 메서드 종료
			return;
		}else if(StringUtils.isNumeric(id)){//입력한 문자열이 숫자형태인경우
			Team team = this.teamDao.getTeam(Integer.parseInt(id));
			if(team == null) {//검색결과가 없는 경우
				System.out.printf("%s인 팀은 존재하지 않습니다.\n", id);
				showTeamField(player);//현재 메서드 다시 실행
			}else {
				player.setTeam_id(Integer.parseInt(id));//선수의 팀번호설정
				showPlayerId(player,team);//선수번호 설정 및 삽입 메서드호출
			}
		}
	}
	protected void showPlayerId(Player p, Team t) {
		final String playerId = "선수 번호";
		showMenu(playerId);
		String id = this.getInputedString();//선수번호를 입력받는다.
		if(StringUtils.isEmpty(id)) {//번호가 없는 경우
			return;//메서드 종료
		}else if(StringUtils.isNumeric(id)) {//입력된 문자열이 숫자인경우
			p.setPlayer_id(Integer.parseInt(id));//선수 번호 설정
			this.playerDao.insertPlayer(p);//DB에 삽입
			System.out.printf("%s 팀에 %s 선수를 등록했습니다.\n", 
					t.getTeam_name(), p.getPlayer_name());
		}
	}
	
	public void show() {
		final String playerName = "선수 이름";
		showMenu(playerName);
		String name = this.getInputedString();//이름을 입력 받는다.
		if(StringUtils.isEmpty(name)) {//이름이 없는 경우
			return;
		}else {
			Player player = new Player();//야구선수용 모델을 생성
			player.setPlayer_name(name);//이름을 설정
			showTeamField(player);//팀번호 설정 메서드 호출
		}
	}
}



















