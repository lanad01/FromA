package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Fruit;
@Repository
public class ItemDaoImpl implements ItemDao {
	@Autowired
	private SqlSession session;
	public List<Fruit> finaAll() {
		return session.selectList("fruits.getItemList");
	}

	public Fruit findById(Integer id) {
		return session.selectOne("fruits.getItem",id);
	}

	public List<Fruit> findByName(String name) {
		return session.selectList("fruits.findItem",name);
	}

	public void create(Fruit item) {
		session.insert("fruits.putItem",item);
	}

	public void delete(Integer id) {
		session.delete("fruits.deleteItem",id);
	}

	public void update(Fruit item) {
		session.update("fruits.updateItem", item);
	}

}
