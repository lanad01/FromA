package model;

import java.util.LinkedList;
import java.util.List;

public class Cart {
	private List<ItemSet> itemList = new LinkedList<ItemSet>();
	public List<ItemSet> getItemList(){//itemList의 게터 메서드
		return itemList;
	}
	public boolean isEmpty() {//장바구니가 비어있는지 확인 메서드
		if(this.itemList== null || this.itemList.isEmpty()) {
			return true;//비어있으면 true가 리턴
		}
		return false;//비어있지 않으면 false가 리턴
	}
	public void clearAll() {//장바구니를 비우는 메서드
		this.itemList = new LinkedList<ItemSet>();
	}
	public void push(ItemSet itemSet) {
		boolean itemAlreadyInCart = false;//이미 있는 물건이지 검사용변수
		Item pushedItem = itemSet.getItem();//상품객체를 불러온다.
		int pushedItemId = pushedItem.getItem_id().intValue();//상품번호
		//장바구니에 담을 상품번호가 이미 장바구니에 있는 검사 시작
		for(ItemSet cartItemSet : this.itemList) {
			Item cartItem = cartItemSet.getItem();//장바구니의 상품불러옴
			int cartItemId = cartItem.getItem_id().intValue();//상품번호
			if(cartItemId == pushedItemId) {
				//장바구니의 상품번호와 장바구니에 담을 상품번호가 같은경우
				cartItemSet.addQuantity(itemSet.getQuantity());//갯수증가
				itemAlreadyInCart = true;
				break;//반복 종료
			}
		}
		//장바구니에 담을 상품번호가 이미 장바구니에 있는 검사 끝
		if(!itemAlreadyInCart) {
			this.itemList.add(itemSet);//장바구니에 상품과 갯수 추가
		}
	}//ItemSet을 장바구니의 itemList에 저장하는 메서드
}




















