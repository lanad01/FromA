package util;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import model.User;

public class UserEntryValidator implements Validator {
	
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		User user = (User)target;
		if( ! StringUtils.hasLength(user.getId())) {
			//입력한id에 길이가 없는 경우, 즉 입력되지 않은 경우
			errors.rejectValue("id", "error.required.user");
		}
		if( ! StringUtils.hasLength(user.getPwd())) {
			//입력한 암호에 길이가 없는 경우, 즉 입력되지 않은 경우
			errors.rejectValue("pwd", "error.required.user");
		}
		if( ! StringUtils.hasLength(user.getName())) {
			errors.rejectValue("name", "error.required.user");
		}
		if( ! StringUtils.hasLength(user.getGender())) {
			errors.rejectValue("gender", "error.required.user");
		}
		if(! StringUtils.hasLength(user.getEmail())) {
			errors.rejectValue("email", "error.required.user");
		}
		if(! StringUtils.hasLength(user.getAddress())) {
			errors.rejectValue("address", "error.required.user");
		}
		if(errors.hasErrors()) {
			errors.reject("error.input.user");
		}
	}

}














