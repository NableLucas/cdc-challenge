package com.nable.cdc.newbook;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.ISBN;
import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.nable.cdc.common.ExistsId;
import com.nable.cdc.common.UniqueValue;
import com.nable.cdc.newauthor.Author;
import com.nable.cdc.newcategory.Category;

public class NewBookRequest {

	@NotBlank
	@UniqueValue(domainClass = Book.class, fieldName = "title")
	private String title;

	@NotBlank
	@Size(max = 500)
	private String review;

	private String summary;

	@Min(value = 20)
	private BigDecimal price;

	@Min(value = 100)
	private int pageNumber;

	// @ISBN
	@UniqueValue(domainClass = Book.class, fieldName = "isbn")
	private String isbn;

	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate publicationDate;

	@Positive
	@ExistsId(domainClass = Category.class, fieldName = "id")
	private Long idCategory;

	@Positive
	@ExistsId(domainClass = Author.class, fieldName = "id")
	private Long idAuthor;

	public NewBookRequest(@NotBlank String title, @NotBlank @Size(max = 500) String review, String summary,
			@NotBlank @Min(20) BigDecimal price, @Min(100) int pageNumber, @ISBN String isbn,
			@Future LocalDate publicationDate, @Positive Long idCategory, @Positive Long idAuthor) {
		super();
		this.title = title;
		this.review = review;
		this.summary = summary;
		this.price = price;
		this.pageNumber = pageNumber;
		this.isbn = isbn;
		this.publicationDate = publicationDate;
		this.idCategory = idCategory;
		this.idAuthor = idAuthor;
	}

	public Book toModel(EntityManager manager) {

		Category category = manager.find(Category.class, idCategory);

		Assert.notNull(category, "Category need to exist");

		Author author = manager.find(Author.class, idAuthor);

		Assert.notNull(author, "Author need to exist");

		return new Book(title, review, summary, price, pageNumber, isbn, publicationDate, category, author);
	}

}
