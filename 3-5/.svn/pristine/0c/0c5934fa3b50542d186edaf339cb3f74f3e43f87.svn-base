package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	@Autowired
	private UserEntryValidator userEntryValidator;
	//DB에 User를 삽입
	@Autowired
	private UserDao userDao;
	//가입자 등록폼의 일부에 메세지를 넣는다.
	@Autowired
	private MessageSource messageSource;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String toUserEntry() {//userEntry.jsp를 띄우는 기능
		return "userentryform/userEntry";
	}
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView onSubmit(User user, BindingResult br) {//버튼을 누른경우 호출되는 메서드
		this.userEntryValidator.validate(user, br);//유효성 검사 실행
		ModelAndView mav = new ModelAndView();
		if(br.hasErrors()) {//유효성 검사 중 에러가 존재하는 경우
			//화면을 바꾸지않고,에러메서지를 출력한다.
			//->에러메세지가 포함된 userEntry.jsp를 유지한다.
			mav.getModel().putAll(br.getModel());
			//br이 가지고 있는 에러메세지를 mav가 가지고 있는 뷰에 출력
			return mav;
		}
		try {
			userDao.entryUser(user);//DB에 새로운 가입자 삽입
			mav.setViewName("userentryform/userEntrySuccess");//등록 후 출력될 JSP 이름
			mav.addObject("user",user);//JSP에 전달할 데이터
			return mav;
		}catch(DataIntegrityViolationException e) {
			//동일한 계정이 존재하는 경우 이 예외가 발생함.
			br.reject("error.duplicate.user");//중복 계정 에러메세지 출력
			mav.getModel().putAll(br.getModel());
			return mav;
		}
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




















