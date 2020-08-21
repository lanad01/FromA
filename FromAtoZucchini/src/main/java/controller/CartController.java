package controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.LoginDao;
import model.User;

@Controller
public class CartController {
	@Autowired
	private LoginDao loginDao;
	
	@RequestMapping(value="/cart/addCart.html")
	public ModelAndView addCart(String CODE, HttpSession session) {
		String id = (String)session.getAttribute("loginUser");
		if(id == null) {//로그인 안한 경우
			ModelAndView mav = new ModelAndView(
				"redirect:/cart/login.html");
			mav.addObject("RESULT","nologin");
			return mav;
		}
		return null;
	}
	@RequestMapping(value="/cart/login.html",method=RequestMethod.POST)
	public ModelAndView cartLogin(@Valid User user,
			BindingResult bindingResult, HttpSession session) {
		if(bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("home/cartLogin");
			return mav;
		}
		ModelAndView mav = new ModelAndView("home/loginResult");
		//DB에서 로그인 시도
		User loginUser = loginDao.findByIdAndPwd(user);

		if(loginUser != null) {//로그인 성공
			session.setAttribute("loginUser", user.getId());//세션에 저장
			mav.addObject("cartLogin","SUCCESS");
		}else {//로그인 실패
			mav.addObject("cartLogin","FAIL");
		}
		return mav;
	}
	
	@RequestMapping(value="/cart/login.html",method=RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("home/cartLogin");
		mav.addObject("RESULT","nocart");
		mav.addObject(new User());
		return mav;
	}
}



















