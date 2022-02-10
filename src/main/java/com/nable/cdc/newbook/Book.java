package com.nable.cdc.newbook;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.nable.cdc.newauthor.Author;
import com.nable.cdc.newcategory.Category;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	private String review;
	
	private String summary;
	
	private BigDecimal price;
	
	private int pageNumber;
	
	private String isbn;
	
	private LocalDate publicationDate;
	
	@ManyToOne
	private Category category;
	
	@ManyToOne
	private Author author;

	public Book(String title, String review, String summary, BigDecimal price, int pageNumber, String isbn,
			LocalDate publicationDate, Category category, Author author) {
		super();
		this.title = title;
		this.review = review;
		this.summary = summary;
		this.price = price;
		this.pageNumber = pageNumber;
		this.isbn = isbn;
		this.publicationDate = publicationDate;
		this.category = category;
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", review=" + review + ", summary=" + summary + ", price=" + price
				+ ", pageNumber=" + pageNumber + ", isbn=" + isbn + ", publicationDate=" + publicationDate
				+ ", category=" + category + ", author=" + author + "]";
	}
	
}
