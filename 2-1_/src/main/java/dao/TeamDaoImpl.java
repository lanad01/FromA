package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;

import model.Team;

public class TeamDaoImpl implements TeamDao { //DAO
	private SqlSession session;
	
	public void setSession(SqlSession session) {
		this.session = session;
	}

	public List<Team> getTeamList() throws DataAccessException {
		List<Team> list=session.selectList("user.getTeamList");
		return list;
	}

}
