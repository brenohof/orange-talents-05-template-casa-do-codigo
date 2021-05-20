package br.com.zupacademy.breno.casadocodigo.controller.validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class IfExistsValidator implements ConstraintValidator<IfExists, String> {

    @PersistenceContext
    private EntityManager em;

    private String field;
    private Class<?> entity;

    @Override
    public void initialize(IfExists constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.entity = constraintAnnotation.entity();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Query query = em.createQuery("Select 1 from " + entity.getName() + " where " + field + " = :value");

        query.setParameter("value", value);

        List<?> result = query.getResultList();

        return result.isEmpty();
    }
}
