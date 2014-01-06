package eu.daxiongmao.tutorial.util.constant;

/**
 * Utility class to maintain the entities fields size.
 * 
 * @author Guillaume Diaz
 * @version 1.0 - January 2014
 */
public final class EntityFieldSize {

	/**
	 * Big text - 500 characters. <br/>
	 * Use it to store the some description of small piece of text.
	 */
	public static final int VARCHAR_BIG_TEXT_500 = 500;

	/**
	 * Medium text - 200 characters. <br/>
	 * Use it to store the user first & last name.
	 */
	public static final int VARCHAR_MEDIUM_TEXT_200 = 200;

	/**
	 * Medium text - 255 characters. <br/>
	 * Use it to store the user email.
	 */
	public static final int VARCHAR_MEDIUM_TEXT_255 = 255;

	/**
	 * Small text - 50 characters. <br/>
	 * Use it for login, names and other specifics attributes.
	 */
	public static final int VARCHAR_SMALL_SIZE_50 = 50;

	/**
	 * Small text - 75 characters. <br/>
	 * Use it to store the user password in hash format.
	 */
	public static final int VARCHAR_SMALL_TEXT_75 = 75;

	/** Private factory design pattern. */
	private EntityFieldSize() {
	}
}
