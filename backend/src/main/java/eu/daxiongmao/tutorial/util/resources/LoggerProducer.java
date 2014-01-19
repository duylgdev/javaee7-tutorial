package eu.daxiongmao.tutorial.util.resources;

import java.util.logging.Logger;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 * <p>
 * Utility class that use CDI to alias JavaEE 7 resources such as Logger, PersistenceContext. <br/>
 * = This enable the use of generic alias through dynamic resource binding using {@link Produces}.
 * </p>
 * <p>
 * This is <u>mandatory</u> to avoid the following error:<br/>
 * <code>WELD-001408 Unsatisfied dependencies for type [...] with qualifiers [@Default] at injection point</code><br/>
 * See Beginning Java EE 7. source:<br/>
 * <a href=
 * "https://github.com/agoncal/agoncal-book-javaee7/blob/master/chapter02/chapter02-putting-together/src/main/java/org/agoncal/book/javaee7/chapter02/LoggingProducer.java"
 * >jee7</a><br/>
 * For quick explanation, see StackOverFlow:
 * <ul>
 * <li><a href="http://stackoverflow.com/questions/11748006/weld-001408-unsatisfied-dependencies-when-injecting-entitymanager">Thread 1</a></li>
 * <li><a href="http://stackoverflow.com/questions/19768405/weld-001408-unsatisfied-dependencies-for-type-logger-with-qualifiers-default">Thread 2</a></li>
 * </ul>
 * </p>
 * </p>
 * 
 * @author Guillaume Diaz - based upon StackOverFlow forum.
 * 
 */
public class LoggerProducer {

	/**
	 * To bind the generic {@link Logger} to the real class that is currently being used. <br/>
	 * = This map the Logger alias to the correct value. <br/>
	 * Logger is retrieve using injection point and class name.
	 * 
	 * @param injectionPoint the injected resource (= current class)
	 * @return current class logger
	 */
	@Produces
	public Logger produceLog(final InjectionPoint injectionPoint) {
		return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
	}

}
