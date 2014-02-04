package eu.daxiongmao.tutorial.backend.service.bookstore.util.impl;

import java.util.Random;
import java.util.logging.Logger;

import javax.inject.Inject;

import eu.daxiongmao.tutorial.backend.service.bookstore.util.BookNumberGenerator;
import eu.daxiongmao.tutorial.backend.service.bookstore.util.qualifier.ThirteenDigits;
import eu.daxiongmao.tutorial.util.interceptor.LoggingInterceptor;

/**
 * To generate the ISBN (13 digits number) book ID.
 * 
 * @author Guillaume Diaz - Based upon "Beginning Java EE 7" by Antonio Goncalves, aPress 2013.
 * @version 1.0 - January 2014
 */
@ThirteenDigits
public class IsbnGenerator implements BookNumberGenerator {

	@Inject
	private Logger logger;

	@LoggingInterceptor
	@Override
	public String generateNumber() {
		// The group is a 1 to 5 digit number. 0 or 1 for English-speaking countries; 2 for French-speaking countries; ..
		String group = "2-";
		String publisher = "75125-";
		String isbn = "ISBN - " + group + publisher + Math.abs(new Random().nextInt());
		logger.info("Generated ISBN: " + isbn);
		return isbn;
	}

}
