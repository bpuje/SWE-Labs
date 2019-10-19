package mum.edu.swe.hcmcpatientsmgmtsystem.domain.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniquePatientNumberValidator.class)
public @interface UniquePatientNumber {
    String message() default "This Patient Number already exist.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
