package eu.daxiongmao.tutorial.backend.service.bookstore.impl;

import eu.daxiongmao.tutorial.backend.service.bookstore.BookNumberGenerator;
import eu.daxiongmao.tutorial.backend.service.bookstore.qualifier.EightDigits;
import java.util.Random;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 * To generate the ISSN (8 to 10 digits number) book ID.
 * 
 * @author Guillaume Diaz - Based upon "Beginning Java EE 7" by Antonio Goncalves, aPress 2013.
 * @version 1.0 - January 2014
 */
@EightDigits
public class IssnGenerator implements BookNumberGenerator {

	@Inject
	private Logger logger;

	@Override
	public String generateNumber() {
		String issn = "8-" + Math.abs(new Random().nextInt());
		logger.info("Generated ISSN: " + issn);
		return issn;
	}

}
