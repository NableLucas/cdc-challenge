package com.nable.cdc.bookdetail;

import com.nable.cdc.newauthor.Author;

public class AuthorDetailResponse {

	private String name;
	private String observations;
	

	public AuthorDetailResponse(Author author) {
		name = author.getName();
		observations = author.getObservations();
	}
	
	public String getName() {
		return name;
	}
	
	public String getObservations() {
		return observations;
	}
}
