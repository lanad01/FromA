package dao;

import java.util.List;

import model.Fruit;

public interface ItemDao {
	List<Fruit> findAll();//모든 과일상품 검색
	Fruit findById(Integer id);//과일번호로 과일상품 검색
	List<Fruit> findByName(String name);//이름으로 과일상품 검색
	void create(Fruit item);//과일상품 등록
	void delete(Integer id);//과일상품 삭제
	void update(Fruit item);//과일상품 정보 변경
}
