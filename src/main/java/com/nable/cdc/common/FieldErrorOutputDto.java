package com.nable.cdc.common;

public class FieldErrorOutputDto {

	private String error;
	private String message;
	
	public FieldErrorOutputDto() {}
	
	public FieldErrorOutputDto(String error, String message) {
		super();
		this.error = error;
		this.message = message;
	}
	
	public String getError() {
		return error;
	}
	
	public String getMessage() {
		return message;
	}
}
