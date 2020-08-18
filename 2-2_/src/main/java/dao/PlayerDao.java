package dao;

import org.springframework.dao.DataAccessException;

import model.Player;

public interface PlayerDao {//인터페이스를 쓰는 이유 : 다형성. 주입을 다양한 방식으로 할 수 있음
	void insertPlayer(Player p) throws DataAccessException;
}
