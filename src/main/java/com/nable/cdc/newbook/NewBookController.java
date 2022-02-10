package com.nable.cdc.newbook;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewBookController {

	@Autowired
	private EntityManager manager;
	
	@PostMapping("/book")
	public String createNewBook(@RequestBody @Valid NewBookRequest request) {
		Book book = request.toModel(manager);
		return book.toString();
	}
}
