package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Sale;
import model.SaleDetail;
@Repository
public class SaleDaoImpl implements SaleDao{
	@Autowired
	private SqlSession session;
	public Integer getNewSaleId() {
		// TODO Auto-generated method stub
		Integer max=this.session.selectOne("sale.getMaxSaleId");
		if(max==null) return 0;
		else return max;
	}
	public void entrySale(Sale sale) { //매출정보 DB삽입
		// TODO Auto-generated method stub
		this.session.insert("sale.putsale",sale);
	}
	public void entrySaleDetail(SaleDetail detail) {
		// TODO Auto-generated method stub
		detail.setSaleId(detail.getSale().getSaleId()); //매출번호 설정
		detail.setItemId(detail.getItem().getItem_id()); //상품번호 설정
		this.session.insert("sale.putSaleDetail",detail);
	}

}
