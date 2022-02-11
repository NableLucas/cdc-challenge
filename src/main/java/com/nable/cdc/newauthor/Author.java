package com.nable.cdc.newauthor;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

import lombok.Data;

@Entity
@Data
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	@Email
	@Column(unique=true)
	private String email;
	
	@Size(max = 400)
	@NotBlank
	private String observations;
	
	private LocalDateTime creationInstant = LocalDateTime.now();
	
	public Author() {
	}

	public Author(String name, @NotBlank @Email String email,
			@Max(400) @NotBlank String observations) {
		
		Assert.hasLength(name, "name is mandatory");
		
		this.name = name;
		this.email = email;
		this.observations = observations;
	}
	
	


	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getObservations() {
		return observations;
	}

	public LocalDateTime getCreationInstant() {
		return creationInstant;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", email=" + email + ", observations=" + observations
				+ ", creationInstant=" + creationInstant + "]";
	}
	
}
