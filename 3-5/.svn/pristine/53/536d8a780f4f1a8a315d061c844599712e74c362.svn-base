package logic;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ItemDao;
import dao.SaleDao;
import dao.UserDao;
import model.Cart;
import model.Item;
import model.ItemSet;
import model.Sale;
import model.SaleDetail;
import model.User;
@Service
public class ShoppingImpl implements Shopping {
	@Autowired
	private ItemDao itemDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private SaleDao saleDao;
	
	public void checkout(User user, Cart cart) {
		Sale sale = createSale(user, cart);
		entrySale(sale);
	}
	private void entrySale(Sale sale) {//매출정보 등록 메서드
		this.saleDao.entrySale(sale);//매출정보 DB 삽입
		//매출 상세 정보 DB 삽입
		List<SaleDetail> saleDetailList = sale.getSaleDetailList();
		for(SaleDetail saleDetail : saleDetailList) {
			this.saleDao.entrySaleDetail(saleDetail);
		}
	}
	private Integer getNewSaleId() {//매출번호 리턴 메서드
		Integer id = this.saleDao.getNewSaleId();
		return id;
	}
	private Timestamp getCurrentTime() {//구매시간 리턴 메서드
		//현재 시간 정보를 Timestamp라는 객체 형태로 만들어서 리턴
		return new Timestamp(Calendar.getInstance().getTimeInMillis());
	}
	private Sale createSale(User user, Cart cart) {
		Sale sale = new Sale();
		sale.setSaleId(getNewSaleId()+1);//매출번호 설정
		sale.setUser(user);//매출고객 설정
		sale.setUserId(user.getId());//매출고객 계정 설정
		Timestamp currentTime = getCurrentTime();//현재 시간을 획득
		sale.setUpdateTime(String.valueOf(currentTime));//구매 시간 설정
		List<ItemSet> itemList = cart.getItemList();//카트에서 상품목록획득
		for(int i=0; i<itemList.size(); i++) {
			ItemSet itemSet = (ItemSet)itemList.get(i);
			int saleDetailId = i + 1;//매출상세정보의 일련번호 설정
			SaleDetail saleDetail = createSaleDetail(sale, saleDetailId,
					itemSet, currentTime);
			sale.addSaleDetail(saleDetail);
		}//카트의 모든 상품목록정보를 매출상세정보로 저장
		return sale;
	}//매출과 매출상세정보를 저장하는 메서드
	private SaleDetail createSaleDetail(Sale sale, int saleDetailId,
			ItemSet itemSet, Timestamp currentTime) {
		return new SaleDetail(sale,new Integer(saleDetailId),
				itemSet, currentTime);
	}//매출 상세 정보 생성 메서드
	public Integer calculateTotal(List<ItemSet> list) {
		int totalAmount = 0;
		for(ItemSet itemSet : list) {
			int price = itemSet.getItem().getPrice().intValue();//가격
			int quantity = itemSet.getQuantity().intValue();//갯수
			totalAmount = totalAmount + (price * quantity);
		}
		return new Integer(totalAmount);
	}//장바구니의 총액 계산 메서드
	public List<Item> getItemList(){
		return this.itemDao.findAll();
	}
	public Item getItemByItemId(Integer itemId) {
		return this.itemDao.findById(itemId);
	}
	public User getUserByUserIdPwd(User user) {
		return this.userDao.findByIdAndPwd(user);
	}
	public void entryUser(User user) {
		this.userDao.entryUser(user);
	}
}
















