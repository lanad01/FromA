package dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;

import dao.PlayerDao;
import model.Player;

public class PlayerDaoImpl implements PlayerDao {
	private SqlSession sqlSession;
	
	public void insertPlayer(Player p) throws DataAccessException {
		sqlSession.insert("user.putPlayer",p);
	}
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

}
