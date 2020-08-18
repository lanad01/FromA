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
@Service //Dao에 접근하는 객체에는 Repository가 아니라 Service, Repository는 DB 접근
public class ShoppingImpl implements Shopping {
	@Autowired
	private ItemDao itemDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private SaleDao saleDao;
	public void checkout(User user, Cart cart) {
		// TODO Auto-generated method stub
		Sale sale=createSale(user, cart);
		entrySale(sale);
	}
	private void entrySale(Sale sale) { // 매출정보 등록 메서드
		this.saleDao.entrySale(sale);
		//매출 상세 정보 등록 DB삽입
		List<SaleDetail> saleDetailList=sale.getSaleDetailList();
		for(SaleDetail saleDetail : saleDetailList) {
			this.saleDao.entrySaleDetail(saleDetail);
		}
	}
	private Integer getNewSaleId() { // 매출번호 리턴
		Integer id=this.saleDao.getNewSaleId();
		return id;
	}
	private Timestamp getCurrentTime() { //구매시간 리턴
		return new Timestamp(Calendar.getInstance().getTimeInMillis());
		//Calendar를 쓰면 다 받아와야하기 떄문에 불편해. 
	}
	private Sale createSale(User user,Cart cart) {
		Sale sale=new Sale(); // sale 모델
		sale.setSaleId(getNewSaleId()); // 매출번호 - 위에 찾아보면 있어 ㅇㅇ saleDao에서 가져온다
		sale.setUser(user); // 매출고객 설정
		sale.setUserId(user.getId()); // 매출고객 계정 설정
		Timestamp currentTime=getCurrentTime(); //현재시간
		sale.setUpdateTime(String.valueOf(currentTime)); //구매시간 설정 Timestamp는 시간객체니까 문자열로 바꿔 
		List<ItemSet> itemList=cart.getItemList();//카트에서 상품목록 획득
		for(int i=0; i<itemList.size(); i++) {
			ItemSet itemSet=(ItemSet)itemList.get(i);
			int saleDetailId=i+1; //매출상세정보의 일련번호 ㄱ
			SaleDetail saleDetail=createSaleDetail(sale, saleDetailId, itemSet, currentTime);
			sale.addSaleDetail(saleDetail);  //상세정보 저장하는 메서드에 상품목록들의 각 정보들을 집어 넣는 반복
		}//카트의 모든 상품 등록 정보를 매출상세정보로 저장
		return sale;
	}// 매출과 매출상세정보를 저장하는 메서드
	private SaleDetail createSaleDetail(Sale sale, int saleDetailId, ItemSet itemSet, 
			Timestamp currentTime) {
		return new SaleDetail(sale, new Integer(saleDetailId), itemSet, currentTime);
		
	}
	public Integer calculateTotal(List<ItemSet> list) {
		// TODO Auto-generated method stub
		int totalAmount=0;
		for(ItemSet itemSet: list) {
			int price=itemSet.getItem().getPrice().intValue();//가격
			int quantity=itemSet.getQuantity().intValue();
			totalAmount=totalAmount+(price*quantity);
		}
		return new Integer(totalAmount);
	}
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
