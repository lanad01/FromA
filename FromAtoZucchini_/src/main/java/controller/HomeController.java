package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping(value="/home/intro.html")
	public ModelAndView intro(String body) {
		ModelAndView mav=new ModelAndView("home/template");
		mav.addObject("BODY",body);
		return mav;
	}
}
