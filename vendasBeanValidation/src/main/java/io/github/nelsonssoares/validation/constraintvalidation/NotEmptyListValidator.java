package io.github.nelsonssoares.validation.constraintvalidation;

import io.github.nelsonssoares.validation.NotEmptyList;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraints.AssertFalse.List;

public class NotEmptyListValidator implements ConstraintValidator<NotEmptyList, List>{

	@Override
	public boolean isValid(List list, ConstraintValidatorContext context) {
		
		return list != null && !list.equals("");
	}
	
	@Override
	public void initialize(NotEmptyList constraintAnnotation) {
		constraintAnnotation.message();
	}

}
