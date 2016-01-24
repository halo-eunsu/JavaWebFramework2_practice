package validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import vo.Member;

@Component
public class MemberValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Member.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Member member = (Member) target;
		
		if(member.getName() == null || member.getName().isEmpty()) {
			errors.rejectValue("name", "required");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
	}

}
