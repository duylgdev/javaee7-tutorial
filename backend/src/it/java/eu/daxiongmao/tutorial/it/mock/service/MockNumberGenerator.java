package eu.daxiongmao.tutorial.it.mock.service;

import java.util.Random;
import java.util.logging.Logger;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import eu.daxiongmao.tutorial.backend.service.bookstore.util.BookNumberGenerator;
import eu.daxiongmao.tutorial.backend.service.bookstore.util.qualifier.ThirteenDigits;
import eu.daxiongmao.tutorial.util.interceptor.LoggingInterceptor;

/**
 * <p>
 * Book ID mock generator. <br/>
 * This can emulate ISBN number [13 digits].
 * </p>
 * <p>
 * <i>Technical note:</i><br/>
 * As this is a mock component (= Alternative), it needs to be declared in the test "beans.xml"<br/>
 * Even though it's a mock it can still use Interceptors. This is why it's annotated {@link LoggingInterceptor}
 * </p>
 * 
 * @author Guillaume Diaz - Based upon "Beginning Java EE 7" by Antonio Goncalves, aPress 2013.
 * @version 1.0 - January 2014
 */
@Alternative
@ThirteenDigits
public class MockNumberGenerator implements BookNumberGenerator {

	/** Logger. */
	@Inject
	private Logger logger;

	@Override
	public String generateNumber() {
		String mock = "MOCK-" + Math.abs(new Random().nextInt());
		logger.info("Generated Mock : " + mock);
		return mock;
	}

}
