package com.nable.cdc.common;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class ExistsIdValidator implements ConstraintValidator<ExistsId, Object>{
	
	private String domainAttribute;
	private Class<?> klass;
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void initialize(ExistsId params) {
		domainAttribute = params.fieldName();
		klass = params.domainClass();
	}

	@Override
	public boolean isValid(Object id, ConstraintValidatorContext context) {
		TypedQuery<Long> query = manager.createQuery("select count(*) from "+klass.getName()+" where "+domainAttribute+"= :id ", Long.class);
		query.setParameter("id", id);
		Long singleResult = query.getSingleResult();
		Assert.isTrue((singleResult >= 1), "Não foi encontrado um id do "+klass.getName());
		return true;
	}
	
	

}
