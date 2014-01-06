/**
 * 
 */
package eu.daxiongmao.tutorial.test.util.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * To check if the given String is a valid email address.
 * 
 * @author Guillaume Diaz - Copy of Anuj's class. <br/>
 *         <a href="http://goldenpackagebyanuj.blogspot.se/2013/05/custom-jsr-303-validation-using-constraintValidator.html">source website</a>
 */
public final class EmailValidationTest {

	/** Javax validator - annotation processor. */
	private static Validator validator;

	/**
	 * Test setup.
	 * 
	 * @throws Exception some error occurred. see the logs
	 */
	@BeforeClass
	public static void setUp() throws Exception {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
	}

	/** Nominal test - valid email. */
	@Test
	public void checkValidEmail() {
		// Test 1 : valid simple email
		TestEntity user1 = new TestEntity();
		user1.setId(1);
		user1.setName("Guillaume");
		user1.setEmail("test@mydomain.com");

		Set<ConstraintViolation<TestEntity>> constraintViolations = validator.validate(user1);
		Assert.assertEquals(0, constraintViolations.size());

		// Test 2 : composed email
		user1.setEmail("myuser.lastname@myserver.mydomain.com");
		constraintViolations = validator.validate(user1);
		Assert.assertEquals(0, constraintViolations.size());

		// Test 3 : composed user name
		user1.setEmail("myuser-firstName.lastname@myserver.mydomain.com");
		constraintViolations = validator.validate(user1);
		Assert.assertEquals(0, constraintViolations.size());
	}

	/** Test border cases. */
	@Test
	public void checkWrongEmail() {
		// Test 1 : missing @domain.com
		TestEntity user1 = new TestEntity();
		user1.setId(1);
		user1.setName("Guillaume");
		user1.setEmail("guillaume");

		Set<ConstraintViolation<TestEntity>> constraintViolations = validator.validate(user1);
		Assert.assertEquals(1, constraintViolations.size());

		// Test 2 : bad characters such as space
		user1.setEmail("guillaume @ wonderful!");
		constraintViolations = validator.validate(user1);
		Assert.assertEquals(1, constraintViolations.size());

		// Test 3 : missing user
		user1.setEmail("@domain.com");
		constraintViolations = validator.validate(user1);
		Assert.assertEquals(1, constraintViolations.size());

		// Test 4 : missing domain extension
		user1.setEmail("guillaume@domain");
		constraintViolations = validator.validate(user1);
		Assert.assertEquals(1, constraintViolations.size());
	}

}
