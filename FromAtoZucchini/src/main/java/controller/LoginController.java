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
public class LoginController {
	@Autowired
	private LoginDao loginDao;
	@RequestMapping(value="/login/loginPost.html",method=RequestMethod.POST)
	public ModelAndView login(@Valid User user,
			BindingResult bindingResult, HttpSession session) {
		if(bindingResult.hasErrors()) {
			System.out.println("logincontroller bind error");
			ModelAndView mav = new ModelAndView("home/template");
			mav.addObject("HEADER","login.jsp");
			return mav;
		}
		User loginUser = loginDao.findByIdAndPwd(user);
		ModelAndView mav = new ModelAndView("home/template");
		if(loginUser != null) {//로그인 성공
			session.setAttribute("loginUser", user.getId());//세션에 저장
		}else {//로그인 실패
			
		}
		mav.addObject("BODY","loginResult.jsp");
		return mav;
	}
	@RequestMapping(value="/login/login.html")
	public ModelAndView toLogin() {
		ModelAndView mav = new ModelAndView("home/login");
		mav.addObject(new User());//폼폼을 위해 객체를 주입
		return mav;
	}
}



















