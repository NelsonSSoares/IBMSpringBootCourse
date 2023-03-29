package io.github.nelsonssoares.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.github.nelsonssoares.validation.constraintvalidation.NotEmptyListValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = NotEmptyListValidator.class)
public @interface NotEmptyList {
	
	String message() default "A Lista Não pode ser vazia";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}


