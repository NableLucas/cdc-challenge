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
	
	public Book() {}

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public LocalDate getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(LocalDate publicationDate) {
		this.publicationDate = publicationDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", review=" + review + ", summary=" + summary + ", price=" + price
				+ ", pageNumber=" + pageNumber + ", isbn=" + isbn + ", publicationDate=" + publicationDate
				+ ", category=" + category + ", author=" + author + "]";
	}
	
}
