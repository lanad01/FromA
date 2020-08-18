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
import model.User;

@Controller
public class EndController {
	@Autowired
	private Shopping shopService;
	
	@RequestMapping
	public ModelAndView end(HttpSession session) {
		//세션에서 Cart와 User를 찾는다.
		User loginUser = (User)session.getAttribute("USER_KEY");
		if(loginUser == null) {//로그인 하지 않은 경우
			throw new LoginRequiredException("로그인 되어있지 않습니다.");
		}
		Cart cart = (Cart)session.getAttribute("CART_KEY");
		if(cart == null || cart.isEmpty()) {//장바구니가 비어있는 경우
			throw new CartEmptyException("카트가 비어있습니다.");
		}
		//Cart가 존재하는 경우, 매출정보를 DB에 저장한다.
		this.shopService.checkout(loginUser, cart);
		cart.clearAll();//구매했으므로, 카트를 비운다.
		ModelAndView mav = new ModelAndView();
		mav.addObject("loginUser", loginUser);
		//end/end 뷰로 화면을 바꾼다.
		return mav;
	}
}
















