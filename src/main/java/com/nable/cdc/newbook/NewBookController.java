package com.nable.cdc.newbook;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewBookController {

	@Autowired
	private EntityManager manager;
	
	@PostMapping("/book")
	@Transactional
	public String createNewBook(@RequestBody @Valid NewBookRequest request) {
		Book book = request.toModel(manager);
		manager.persist(book);
		return book.toString();
	}
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBoks(){
		TypedQuery<Book> q = manager.createQuery("select b from Book b", Book.class);
		
		List<Book> resultList = q.getResultList();
		
		return ResponseEntity.ok().body(resultList);
	}
}
