package eu.daxiongmao.tutorial.util.interceptor.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import eu.daxiongmao.tutorial.util.interceptor.LoggingInterceptor;
import eu.daxiongmao.tutorial.util.resources.LoggerProducer;

/**
 * <p>
 * Logging interceptor (implementation).<br/>
 * This allow automatic logging in / out class or method.<br/>
 * Source: "Beginning Java EE 7" - Chp 2 <i>Class Interceptors</i> p47.
 * </p>
 * <p>
 * Interceptor priority = Application. See {@link Interceptor.Priority} for more details.
 * </p>
 * <p>
 * <strong>IMPORTANT NOTE:</strong><br/>
 * This class is using a generic Logger. Therefore, you must use a Producer to associate the logger to the current class. See {@link LoggerProducer}
 * </p>
 * <p>
 * <i>Key note:</i><br/>
 * Notice the {@link Interceptor} annotation.
 * </p>
 * 
 * @author Guillaume Diaz - Based upon "Beginning Java EE 7" by Antonio Goncalves, aPress 2013.
 * @version 1.0 - January 2014
 */
@Interceptor
@LoggingInterceptor
@Priority(Interceptor.Priority.APPLICATION)
public class LoggingInterceptorImpl {

	/**
	 * Log level to use for this interceptor.
	 */
	private static final Level LOG_LEVEL = Level.FINER;

	/**
	 * Target class logger.
	 */
	@Inject
	private Logger logger;

	/** Default constructor. */
	public LoggingInterceptorImpl() {

	}

	/**
	 * To intercept Class constructor calls.<br/>
	 * Thanks to the try {} finally {} the constructor end is also captured.<br/>
	 * Log level: {@link #LOG_LEVEL}
	 * 
	 * @param ic the invocation context. <br/>
	 *            Don't forget to resume the original call using <code>ic.proceed();</code> at the end
	 * @throws Exception an error happened. This is required to use the try {} finally {}
	 */
	@AroundConstruct
	public void logConstructor(final InvocationContext ic) throws Exception {
		if (logger.isLoggable(LOG_LEVEL)) {
			logger.log(LOG_LEVEL, "Entering constructor");
			try {
				ic.proceed();
			} finally {
				logger.log(LOG_LEVEL, "Exiting constructor");
			}
		} else {
			// Log level not enable >> direct call
			ic.proceed();
		}
	}

	/**
	 * To intercept method execution calls.<br/>
	 * Thanks to the try {} finally {} the method end is also captured.<br/>
	 * Therefore, this interceptor logs both:
	 * <ul>
	 * <li>Start / stop method execution</li>
	 * <li>Execution time (ms)</li>
	 * </ul>
	 * <br/>
	 * Log level: {@link #LOG_LEVEL}
	 * 
	 * @param ic the invocation context. <br/>
	 *            Don't forget to resume the original call using <code>ic.proceed();</code> at the end
	 * @return the target method return value, if any. <br/>
	 *         Thanks to the Object declaration this can intercept any kind of method.
	 * @throws Exception an error happened. This is required to use the try {} finally {}
	 */
	@AroundInvoke
	public Object logMethod(final InvocationContext ic) throws Exception {
		logger.log(LOG_LEVEL, ">>>> Entering method");

		// Alternative to the previous method = default entering / exiting methods
		// Entering is using Level.FINER
		logger.entering(ic.getTarget().toString(), ic.getMethod().getName());
		long initTime = System.currentTimeMillis();
		try {
			return ic.proceed();
		} finally {
			long executionTime = System.currentTimeMillis() - initTime;
			String logMsg = "- execution time (ms): %s";
			logger.exiting(ic.getTarget().toString(), ic.getMethod().getName(), String.format(logMsg, executionTime));
		}
	}

}
