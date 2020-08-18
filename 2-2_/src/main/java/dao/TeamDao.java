package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import model.Team;

public interface TeamDao {
	List<Team> getTeamList() throws DataAccessException;
	Team getTeam(Integer id) throws DataAccessException; //선수가 들어갈 팀을 골라오는 추상메서드
}
