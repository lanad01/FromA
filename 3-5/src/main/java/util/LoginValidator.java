package util;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import model.User;

public class LoginValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		User user = (User)target;//검증의 대상 객체
		if( ! StringUtils.hasLength(user.getId())) {//계정이 없는 경우
			errors.rejectValue("id", "error.required");
		}
		if( ! StringUtils.hasLength(user.getPwd())) {//암호가 없는 경우
			errors.rejectValue("pwd", "error.required");
		}
		if( errors.hasErrors()) {//항목에 문제가 있는 경우
			errors.reject("error.input.user");
		}
	}

}





















