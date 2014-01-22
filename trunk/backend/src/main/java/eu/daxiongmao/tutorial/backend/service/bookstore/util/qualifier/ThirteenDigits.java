package eu.daxiongmao.tutorial.backend.service.bookstore.util.qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.inject.Qualifier;

/**
 * Qualifier to designate the ISBN (13 digits) book ID generator.
 * 
 * @author Guillaume Diaz - Based upon "Beginning Java EE 7" by Antonio Goncalves, aPress 2013.
 * @version 1.0 - January 2014
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE })
public @interface ThirteenDigits {
}
