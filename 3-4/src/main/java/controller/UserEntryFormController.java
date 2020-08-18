package controller;

import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.UserDao;
import model.User;
import util.UserEntryValidator;

@Controller
public class UserEntryFormController {
	//입력된 정보 유효성 검사
	private UserEntryValidator userEntryValidator;
	//DB에 User를 삽입
	private UserDao userDao;
	//가입자 등록폼의 일부에 메세지를 넣는다.
	private MessageSource messageSource;
	public void setUserEntryValidator(UserEntryValidator userEntryValidator) {
		this.userEntryValidator = userEntryValidator;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	@RequestMapping(method=RequestMethod.GET)
	public String toUserEntry() {//userEntry.jsp를 띄우는 기능
		return "userEntry";
	}
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView onSubmit() {//버튼을 누른경우 호출되는 메서드
		return null;
	}
	
	@ModelAttribute
	public User setup() {
		User user = new User();
		MessageSourceAccessor ms = new MessageSourceAccessor(
				this.messageSource);//객체에 메세지를 삽입하는 객체
		user.setId(ms.getMessage("user.id.default"));
		user.setName(ms.getMessage("user.name.default"));
		return user;
	}
}




















