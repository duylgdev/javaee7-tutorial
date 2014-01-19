package eu.daxiongmao.tutorial.util.interceptor;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.interceptor.InterceptorBinding;

/**
 * <p>
 * Logging interceptor (declaration).<br/>
 * This allow automatic logging in / out class or method.<br/>
 * Source: "Beginning Java EE 7" - Chp 2 <i>Class Interceptors</i> p51.
 * </p>
 * 
 * @author Guillaume Diaz - Based upon "Beginning Java EE 7" by Antonio Goncalves, aPress 2013.
 * @version 1.0 - January 2014
 */
@Documented
@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE })
public @interface LoggingInterceptor {

}
