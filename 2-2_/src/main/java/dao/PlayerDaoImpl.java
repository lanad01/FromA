package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;

import model.Player;

public class PlayerDaoImpl implements PlayerDao {
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	public void insertPlayer(Player p) throws DataAccessException {
		sqlSession.insert("user.putPlayer",p);
	}

}
