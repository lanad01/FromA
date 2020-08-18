package model;

import java.util.ArrayList;
import java.util.List;

public class Sale {//매출정보
	private User user;
	private Integer saleId;
	private String userId;
	private String updateTime;
	private List<SaleDetail> saleDetailList = 
			new ArrayList<SaleDetail>();
	public void addSaleDetail(SaleDetail detail) {
		this.saleDetailList.add(detail);
	}//세일 상세 정보 추가 메서드
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getSaleId() {
		return saleId;
	}
	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updatetime) {
		this.updateTime = updatetime;
	}
	public List<SaleDetail> getSaleDetailList() {
		return saleDetailList;
	}
	public void setSaleDetailList(List<SaleDetail> saleDetailList) {
		this.saleDetailList = saleDetailList;
	}
}















