/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.daxiongmao.tutorial.model.bookstore;

/**
 * 
 * @author guiho_000
 */
public class Book {

	private String title;
	private Float price;
	private String description;
	private String number;

	public Book() {
	}

	public Book(final String title, final Float price, final String description) {
		this.title = title;
		this.price = price;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(final Float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(final String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		String log = "Book # Title: %s | Number: %s | Price: %s | Description: %s";
		return String.format(log, title, number, price, description);
	}

}
