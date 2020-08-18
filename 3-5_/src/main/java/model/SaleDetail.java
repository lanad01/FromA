package model;

import java.sql.Timestamp;

public class SaleDetail { //매출상세
	public SaleDetail(Sale sale, Integer saleDetailId, ItemSet itemSet, Timestamp currentTime) {
		this.sale=sale; 
		this.saleDetailId=saleDetailId; 
		this.item=itemSet.getItem();
		this.quantity=itemSet.getQuantity();
		this.updateTime=String.valueOf(currentTime);
	}
	private Integer saleId;
	private Integer itemId;
	private Sale sale;
	private Item item;
	private String updateTime;
	private Integer quantity;
	private Integer saleDetailId;
	public Integer getSaleId() {
		return saleId;
	}
	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Sale getSale() {
		return sale;
	}
	public void setSale(Sale sale) {
		this.sale = sale;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updatetime) {
		this.updateTime = updatetime;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getSaleDetailId() {
		return saleDetailId;
	}
	public void setSaleDetailId(Integer saleDetailId) {
		this.saleDetailId = saleDetailId;
	}
}
