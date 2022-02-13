package com.nable.cdc.bookdetail;

import java.util.Objects;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nable.cdc.newbook.Book;

@RestController
public class BookDetailController {

	@Autowired
	private EntityManager manager;

	@GetMapping(value = "products/{id}")
	public ResponseEntity<?> getDetailBook(@PathVariable("id") Long id) {

		Book bookFound = manager.find(Book.class, id);
		if (Objects.nonNull(bookFound)) {
			return ResponseEntity.notFound().build();
		}

		BookDetailResponse bookDetailResponse = new BookDetailResponse(bookFound);

		return ResponseEntity.ok().body(bookDetailResponse);
	}
}
