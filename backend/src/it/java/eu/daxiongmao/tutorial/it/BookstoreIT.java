package eu.daxiongmao.tutorial.it;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import eu.daxiongmao.tutorial.backend.service.bookstore.BookService;
import eu.daxiongmao.tutorial.model.bookstore.Book;

/**
 * <p>
 * Test of the book service.
 * </p>
 * <p>
 * Technical note:<br/>
 * The context is loaded using light-weight IoC JBoss WELD.<br/>
 * WELD only take care of Beans injections, qualifiers, alternatives and interceptors. Therefore, even if you're using advanced stuff such as JPA it will not be
 * a problem!! :)<br/>
 * Those tests only provided dependency injection:<br/>
 * = you still have to mock the global input / output !!
 * 
 * @author Guillaume Diaz - Based upon "Beginning Java EE 7" by Antonio Goncalves, aPress 2013.
 * @version 1.0 - February 2014
 * 
 */
public class BookstoreIT {

	/**
	 * Test to create a new book using a real generator ID.
	 */
	@Ignore
	@Test
	public void testCreateBookUsing() {
		// Initialize light-weight container to test the IoC and core JEE 7
		Weld smallContainer = new Weld();
		WeldContainer container = smallContainer.initialize();

		// Target service to test
		// Note: target service is retrieve using container
		BookService bookService = container.instance().select(BookService.class).get();

		Book book = bookService.createBook("H2G2", 12.5f, "Geeky scifi Book");
		Assert.assertTrue(book.getNumber().startsWith("ISBN"));

		// Stop the container
		smallContainer.shutdown();
	}

}
