package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import model.Item;

public class ItemDaoImpl implements ItemDao {
	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}
	public List<Item> findAll() {
		List<Item> list=session.selectList("user.getItemList"); //매퍼의 네임스페이스+쿼리id
		return list;
	}
	public Item findById(Integer id) {
		Item item=session.selectOne("user.getItem",id);
		return item;
	}

}
