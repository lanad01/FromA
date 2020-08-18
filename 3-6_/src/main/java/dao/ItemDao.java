package dao;

import java.util.List;

import model.Fruit;

public interface ItemDao {
	List<Fruit> finaAll();
	Fruit findById(Integer id);
	List<Fruit> findByName(String name);
	void create(Fruit item);
	void delete(Integer id);
	void update(Fruit item);
}
