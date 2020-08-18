package model;

public class ItemSet {
	public void subQuantity(Integer addQuantity) {
		int number = addQuantity.intValue();//정수로 바꾼다.
		int current = this.getQuantity().intValue();//현재갯수를 정부로바꿈
		this.setQuantity(new Integer(current-number));//현재갯수-감소갯수
	}//상품의 갯수 감소 메서드
	public void addQuantity(Integer addQuantity) {
		int number = addQuantity.intValue();//정수로 바꾼다.
		int current = this.getQuantity().intValue();//현재갯수를 정부로바꿈
		this.setQuantity(new Integer(number+current));//현재갯수+추가갯수
	}//상품의 갯수 증가 메서드
	private Item item;//장바구니에 담길 상품객체
	private Integer quantity;//상품의 갯수
	public ItemSet(Item item, Integer quantity) {//생성자
		this.item = item; this.quantity = quantity;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}








