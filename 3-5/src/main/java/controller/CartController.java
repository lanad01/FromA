package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.ItemDao;
import model.Cart;
import model.Item;
import model.ItemSet;
import model.User;

@Controller
public class CartController {
	@Autowired
	private ItemDao itemDao;
	
	@RequestMapping(value="/cart/cartConfirm.html")
	public ModelAndView confirm(HttpSession session) {
		//장바구니 확인을 눌렀을 때 호출되는 메서드
		Cart cart = (Cart)session.getAttribute("CART_KEY");
		if(cart == null) {
			cart = itemDao.getCart();
		}
		ModelAndView mav = new ModelAndView("cart/cart");
		mav.addObject("cart",cart);
		User user = (User)session.getAttribute("USER_KEY");
		if(user != null) {
			mav.addObject("loginUser",user);
		}
		session.setAttribute("CART_KEY", cart);
		return mav;
	}
	@RequestMapping(value="/cart/cartClear.html")
	public ModelAndView clear(HttpSession session) {
		//장바구니 비우기를 눌렀을 때 호출되는 메서드
		Cart cart = (Cart)session.getAttribute("CART_KEY");
		if(cart == null) {
			cart = itemDao.getCart();
		}
		cart.clearAll();//장바구니를 비움
		ModelAndView mav = new ModelAndView("cart/cart");
		User user = (User)session.getAttribute("USER_KEY");
		if(user != null) {//로그인 한 경우
			mav.addObject("loginUser",user);
		}
		mav.addObject("message","카트를 비웠습니다.");
		return mav;
	}
	@RequestMapping(value="/cart/cartAdd.html")
	public ModelAndView add(Integer itemId, Integer quantity, 
			HttpSession session) {
		//장바구니 담기를 눌렀을 때 호출되는 메서드
		//할일:itemId로 DB에서 상품정보를 검색(select)한다.
		//     검색결과가 존재하면 Cart에 해당상품정보를 저장한다.
		//	   Cart를 세션에 저장한다.
		Item item = itemDao.findById(itemId);
		Cart cart = (Cart)session.getAttribute("CART_KEY");
		if(cart == null) {//로그인 후 처음 장바구니에 상품을 담는 경우
			cart = itemDao.getCart();
		}
		cart.push(new ItemSet(item, quantity));//장바구니에 상품+갯수 저장
		session.setAttribute("CART_KEY", cart);//장바구니를 세션에 저장
		session.setAttribute("ITEM_KEY", item);//장바구니에 담은상품을 세션에 저장
		session.setAttribute("NUMBER", quantity);//상품의 갯수를 세션에 저장
		//장바구니에 상품을 담은 결과(JSP)를 출력
		ModelAndView mav = new ModelAndView("redirect:/cart/result.html");
		return mav;
	}
	@RequestMapping(value="/cart/result.html")
	public ModelAndView result(HttpSession session) {
		Cart cart = (Cart)session.getAttribute("CART_KEY");
		Item item = (Item)session.getAttribute("ITEM_KEY");
		int quantity = (Integer)session.getAttribute("NUMBER");
		User user = (User)session.getAttribute("USER_KEY");
		ModelAndView mav = new ModelAndView("cart/cart");//JSP이름 설정
		if(user != null) {//로그인 한 경우
			mav.addObject("loginUser",user);
		}
		mav.addObject("message",item.getItem_name()+"을(를) "+
				quantity+"개 카트에 담았습니다.");
		mav.addObject("cart",cart);
		return mav;
	}
}




















