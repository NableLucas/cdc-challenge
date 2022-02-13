package com.nable.cdc.bookdetail;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

import com.nable.cdc.newbook.Book;

public class BookDetailResponse {
	
	private String title;
	private AuthorDetailResponse author;
	private String isbn;
	private int pageNumber;
	private BigDecimal price;
	private String revire;
	private String summary;
	private String publicationDate;
	
	public BookDetailResponse() {}

	public BookDetailResponse(Book book) {
		
		title = book.getTitle();
		author = new AuthorDetailResponse(book.getAuthor());
		isbn = book.getIsbn();
		pageNumber = book.getPageNumber();
		price = book.getPrice(); 
		revire = book.getReview();
		summary = book.getSummary();
		publicationDate = book.getPublicationDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	public String getTitle() {
		return title;
	}

	public AuthorDetailResponse getAuthor() {
		return author;
	}

	public String getIsbn() {
		return isbn;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getRevire() {
		return revire;
	}

	public String getSummary() {
		return summary;
	}
	
	public String getPublicationDate() {
		return publicationDate;
	}
	
	

}
