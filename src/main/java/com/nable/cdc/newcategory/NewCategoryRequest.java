package com.nable.cdc.newcategory;

import javax.validation.constraints.NotBlank;

import com.nable.cdc.common.UniqueValue;

public class NewCategoryRequest {

	@NotBlank
	@UniqueValue(domainClass = Category.class, fieldName = "name")
	private String name;

	public NewCategoryRequest() {}
	
	public NewCategoryRequest(@NotBlank String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public Category toModel() {
		return new Category(name);
	}
}
