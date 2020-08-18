package ui;

import org.apache.commons.lang3.StringUtils;

import dao.PlayerDao;
import dao.TeamDao;
import model.Player;
import model.Team;

public class InsertPlayerUi extends AbstractUi {
	private TeamDao teamDao; //팀번호로 팀을 검색하기 위한 선언
	private PlayerDao playerDao; // 선수삽입을 위한 선수객체 선언
	
	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}

	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}
	protected void showMenu(String msg) {
		System.out.println("-------------------------");
		System.out.printf("%s 를 입력하고 Enter를 누르세요.\n", msg);
		System.out.println("아무것도 입력하지 않고 Enter를 누르면 메뉴로 돌아갑니다.\n");
		
	}
	protected void showTeamField(Player player) {
		final String teamId="팀번호";
		showMenu(teamId);
		String id=this.getInputedString(); //화면을 통해 입력받은 id
		if(StringUtils.isEmpty(id)) { //입력받은게 없다면 메서드 종료
			return;
		}else if(!StringUtils.isNumeric(id)) {
			Team team=this.teamDao.getTeam(Integer.parseInt(id));//this teamDao를 통해 팀 얻어오기
			if(team==null) {
				System.out.printf("%s인 팀은 존재하지 않습니다\n",id);
				showTeamField(player);
			}else { //검색된 팀이 있다?
				player.setTeam_id(Integer.parseInt(id));//선수의 팀번호 설정
				showPlayerId(player,team); //선수번호 설정 메서드 호출 
			}
		}
	}
	protected void showPlayerId(Player p, Team t) {
		final String playerId="선수번호";
		showMenu(playerId);
		String id=this.getInputedString();
		if(StringUtils.isEmpty(id)) {//번호가없는 경우
			return;
		}else if(StringUtils.isNumeric(id)) {
			p.setPlayer_id(Integer.parseInt(id));
			this.playerDao.insertPlayer(p);//DB에 삽입
			System.out.printf("%s 팀에 %s 선수를 등록했습니다\n", t.getTeam_name(),p.getPlayer_name());
		}
	}
	public void show() {
		final String playerName="선수 이름";
		showMenu(playerName);
		String name=this.getInputedString();
		if((StringUtils.isEmpty(name))) {
			return;
		}else {
			Player player=new Player();
			player.setPlayer_name(name);
			showTeamField(player);//팀번호 설정
		}
	}

}
