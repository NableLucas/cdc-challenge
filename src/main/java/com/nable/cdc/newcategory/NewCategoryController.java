package com.nable.cdc.newcategory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NewCategoryController {

	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping("/category")
	@Transactional
	public String createNewCategory(@RequestBody @Valid NewCategoryRequest request){
		Category category = request.toModel();
		manager.persist(category);
		return category.toString();
	}
}
