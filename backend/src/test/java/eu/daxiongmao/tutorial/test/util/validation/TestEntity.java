package eu.daxiongmao.tutorial.test.util.validation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import eu.daxiongmao.tutorial.util.validation.EmailValidation;

/**
 * Entity that describes an user.
 * 
 * @author Guillaume Diaz
 * @version 1.0 - September 2013
 */
public final class TestEntity {

	/** Email = target attribute to test. */
	@NotNull
	@EmailValidation(message = "not a valid email")
	@Size(min = 5, max = 50)
	private String email;

	/** Id. */
	@NotNull
	private Integer id;

	/** Name. */
	@NotNull
	@Size(min = 3, max = 255)
	private String name;

	/**
	 * @return the {@link #email}
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the {@link #id}
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the {@link #name}
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param email the {@link #email} to set
	 */
	public void setEmail(final String email) {
		this.email = email;
	}

	/**
	 * @param id the {@link #id} to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * @param name the {@link #name} to set
	 */
	public void setName(final String name) {
		this.name = name;
	}

}
