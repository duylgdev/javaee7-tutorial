package eu.daxiongmao.tutorial.backend.service.bookstore;

import eu.daxiongmao.tutorial.backend.service.bookstore.util.BookNumberGenerator;
import eu.daxiongmao.tutorial.backend.service.bookstore.util.qualifier.ThirteenDigits;
import eu.daxiongmao.tutorial.model.bookstore.Book;
import eu.daxiongmao.tutorial.util.interceptor.LoggingInterceptor;

import javax.inject.Inject;

/**
 * <p>
 * Book Service.<br/>
 * Source: "Beginning Java EE 7" - Chp 2 p59.
 * </p>
 * 
 * @author Guillaume Diaz - Based upon "Beginning Java EE 7" by Antonio Goncalves, aPress 2013.
 * @version 1.0 - January 2014
 */
@LoggingInterceptor
public class BookService {

	/**
	 * Book ID number generator. <br/>
	 * Use the annotations to change the qualifier.
	 */
	@Inject
	@ThirteenDigits
	private BookNumberGenerator numberGenerator;

	/**
	 * To create a new book.<br/>
	 * The ISBN number (= book ID) is generated using the Number Generator.
	 * 
	 * @param title the book title
	 * @param price price of the book. Must be >= 0.0
	 * @param description book description
	 * @return new book using given parameters
	 */
	public Book createBook(final String title, final Float price, final String description) {
		if (price < 0) {
			throw new IllegalArgumentException("A price must be >= 0.00");
		}

		Book newBook = new Book(title, price, description);
		newBook.setNumber(numberGenerator.generateNumber());
		return newBook;
	}

}
