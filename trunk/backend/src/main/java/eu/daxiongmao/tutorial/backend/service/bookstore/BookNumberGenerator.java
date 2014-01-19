package eu.daxiongmao.tutorial.backend.service.bookstore;

/**
 * To generate the book ID = either an ISBN or ISSN number.
 * 
 * @author Guillaume Diaz - Based upon "Beginning Java EE 7" by Antonio Goncalves, aPress 2013.
 * @version 1.0 - January 2014
 */
public interface BookNumberGenerator {

	/**
	 * To get a new ISBN number.
	 * 
	 * @return the new book ID (=ISBN number)
	 */
	String generateNumber();
}
