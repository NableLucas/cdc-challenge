package com.nable.cdc.newauthor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.nable.cdc.common.UniqueValue;

public class NewAuthorRequest {
	
	@NotBlank
	private String name;
	
	@Email
	@NotBlank
	@UniqueValue(domainClass = Author.class, fieldName = "email")
	private String email;
	
	@Size(max = 400)
	@NotBlank
	private String observations;
	
	public NewAuthorRequest(@NotBlank String name, @Email @NotBlank String email,
			@Max(400) @NotBlank String observations) {
		this.name = name;
		this.email = email;
		this.observations = observations;
	}


	public Author toModel() {
		return new Author(this.name, this.email, this.observations);
	}	      
}
