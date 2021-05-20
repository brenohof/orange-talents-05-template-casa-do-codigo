package br.com.zupacademy.breno.casadocodigo.validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {

    @PersistenceContext
    private EntityManager em;

    private String field;
    private Class<?> entity;

    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.entity = constraintAnnotation.entity();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = em.createQuery("Select 1 from " + entity.getName() + " where " + field + " = :value");

        query.setParameter("value", value);

        List<?> result = query.getResultList();
        boolean isValid = result.isEmpty();

        return isValid;
    }
}
