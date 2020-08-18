package dao;

import model.Sale;
import model.SaleDetail;

public interface SaleDao {
	void entrySale(Sale sale); //Sale모델에 삽입 매출정보 삽입
	void entrySaleDetail(SaleDetail detail); // 매출 상세 정보 삽입
	Integer getNewSaleId(); // 새로운 매출정보 있을 시 번호 얻기
	
}
