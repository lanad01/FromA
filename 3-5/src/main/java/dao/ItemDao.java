package dao;

import java.util.List;

import model.Cart;
import model.Item;

public interface ItemDao {
	Cart getCart();//장바구니 객체(Cart)를 생성하는 메서드
	List<Item> findAll();//모든 과일 검색
	Item findById(Integer id);//특정 과일 검색
}
