package dao;

import model.Sale;
import model.SaleDetail;

public interface SaleDao {
	void entrySale(Sale sale);//매출 정보 삽입
	void entrySaleDetail(SaleDetail detail);//매출 상세 정보 삽입
	Integer getNewSaleId();//매출 번호 생성
}
