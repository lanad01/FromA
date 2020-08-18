package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {
	
	@RequestMapping
	public ModelAndView logout(HttpSession session) {
		//로그아웃 : 세션을 비활성화 한다.
		session.invalidate();//세션 비활성화
		//JSP선언 logout/logout.jsp
		ModelAndView mav = new ModelAndView("logout/logout");
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("logout/logout");
		return mav;
	}
}


















