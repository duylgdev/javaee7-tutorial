package eu.daxiongmao.tutorial.util.validation;

import eu.daxiongmao.tutorial.util.validation.impl.EmailValidationImpl;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;

/**
 * <p>
 * New annotation to validate an email.
 * </p>
 * <p>
 * Usage:<br/>
 * &#64;EmailValidation on a field.<br/>
 * <br/>
 * <i>example:</i><br/>
 * &#64;EmailValidation<br/>
 * private String email;
 * </p>
 * 
 * @author Guillaume Diaz - Copy of Anuj's class. <br/>
 *         <a href="http://goldenpackagebyanuj.blogspot.se/2013/05/custom-jsr-303-validation-using-constraintValidator.html">source website</a>
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE })
@Constraint(validatedBy = EmailValidationImpl.class)
public @interface EmailValidation {

	Class[] groups() default {};

	/**
	 * Message to raise in case of validation error.
	 */
	String message();

	Class[] payload() default {};
}
