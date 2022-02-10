
package com.nable.cdc.newauthor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//2
public class NewAuthorController {

	
	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping(value = "/author")
	@Transactional
	//1
	//2
	public String createNewAuthor(@RequestBody @Valid NewAuthorRequest request){
		Author author = request.toModel();
		manager.persist(author);
		System.out.println(author.toString());
		return author.toString();
	}
	
}
