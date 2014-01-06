/**
 * 
 */
package eu.daxiongmao.tutorial.util.validation.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import eu.daxiongmao.tutorial.util.validation.EmailValidation;

/**
 * To check if the given String is a valid email address.
 * 
 * @author Guillaume Diaz - Copy of Anuj's class. <br/>
 *         <a href="http://goldenpackagebyanuj.blogspot.se/2013/05/custom-jsr-303-validation-using-constraintValidator.html">source website</a>
 */
public class EmailValidationImpl implements ConstraintValidator<EmailValidation, String> {

	/** Control regex. */
	private static final String EMAIL_PATTERN = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";

	/** Java regex expression. */
	private Pattern pattern;

	@Override
	public final void initialize(final EmailValidation constraintAnnotation) {
		pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
	}

	@Override
	public final boolean isValid(final String email, final ConstraintValidatorContext context) {
		boolean isValidEmail = false;

		CharSequence emailstr = email;
		Matcher matcher = pattern.matcher(emailstr);

		if (matcher.matches()) {
			isValidEmail = true;
		}

		return isValidEmail;
	}

}
