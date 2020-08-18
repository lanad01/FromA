package dao;

import java.util.List;

import model.Item;

public interface ItemDao {
	List<Item> findAll();
	Item findById(Integer id); //특정 과일 검색
}
