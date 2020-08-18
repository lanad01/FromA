package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import exception.CartEmptyException;
import exception.LoginRequiredException;
import logic.Shopping;
import model.Cart;
import model.Sale;
import model.User;

@Controller
public class EndController {
	@Autowired
	private Shopping shopService;
	@RequestMapping
	public ModelAndView end(HttpSession session) { // 리퀘스트맵핑 - 콜백 메서드 바로 수행됨 
		//세션에서 카트와 user를 찾는다.
		User loginUser=(User)session.getAttribute("USER_KEY");
		if(loginUser==null) {
			throw new LoginRequiredException("로그인 되어 있지 않습니다.");
		}
		Cart cart=(Cart)session.getAttribute("CART_KEY");
		if(cart==null || cart.isEmpty()) {
			throw new CartEmptyException("카트가 비어있습니다");
		}
		//카트가 존재할 경우, 매출정보를 DB에 저장한다
		this.shopService.checkout(loginUser, cart); // shoppingImpl에 있습니다
//		public void checkout(User user, Cart cart) {
//			Sale sale=createSale(user, cart);
//			entrySale(sale); }
		cart.clearAll(); //구매했으므로 카드를 비운다
		ModelAndView mav=new ModelAndView("end/end");
		mav.addObject("loginUser",loginUser);
		//end/end.jsp로 화면을 바꾼다
		return mav;
	}
}
