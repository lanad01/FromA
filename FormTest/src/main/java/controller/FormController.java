package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bean.MemberBean;

public class FormController {
	@RequestMapping(value = "joinUpCompletee", method=RequestMethod.POST)
	public String joinUpCompletee(@ModelAttribute MemberBean bean, Model model, 
			HttpServletRequest request) {
		System.out.println("Vaild 들어오나?");
		model.addAttribute("bean", bean);
		
		return "session/joinUpComplete";
	}
}
