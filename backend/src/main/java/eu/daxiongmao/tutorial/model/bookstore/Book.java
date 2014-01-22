/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.daxiongmao.tutorial.model.bookstore;

/**
 * This represents a book.
 * 
 * @author Guillaume Diaz - Based upon "Beginning Java EE 7" by Antonio Goncalves, aPress 2013.
 * @version 1.0 - January 2014
 */
public class Book {

	/** Book description. */
	private String description;
	/** Book ID = unique number. */
	private String number;
	/** Book price. */
	private Float price;
	/** Book title. */
	private String title;

	/** Default constructor. */
	public Book() {
	}

	/**
	 * To create a new book.
	 * 
	 * @param title book title
	 * @param price book price
	 * @param description book description
	 */
	public Book(final String title, final Float price, final String description) {
		this.title = title;
		this.price = price;
		this.description = description;
	}

	/**
	 * @return {@link #description}
	 */
	public final String getDescription() {
		return description;
	}

	/**
	 * @return {@link #number}
	 */
	public final String getNumber() {
		return number;
	}

	/**
	 * @return {@link #price}
	 */
	public final Float getPrice() {
		return price;
	}

	/**
	 * @return {@link #title}
	 */
	public final String getTitle() {
		return title;
	}

	/**
	 * @param description the {@link #description} to set
	 */
	public final void setDescription(final String description) {
		this.description = description;
	}

	/**
	 * @param number the {@link #number} to set
	 */
	public final void setNumber(final String number) {
		this.number = number;
	}

	/**
	 * @param price the {@link #price} to set
	 */
	public final void setPrice(final Float price) {
		this.price = price;
	}

	/**
	 * @param title the {@link #title} to set
	 */
	public final void setTitle(final String title) {
		this.title = title;
	}

	@Override
	public final String toString() {
		String log = "Book # Title: %s | Number: %s | Price: %s | Description: %s";
		return String.format(log, title, number, price, description);
	}

}
