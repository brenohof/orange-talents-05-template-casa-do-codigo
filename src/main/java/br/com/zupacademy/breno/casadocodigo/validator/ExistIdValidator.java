package br.com.zupacademy.breno.casadocodigo.validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistIdValidator implements ConstraintValidator<ExistId, Long> {

    @PersistenceContext
    private EntityManager em;

    private Class<?> entity;

    @Override
    public void initialize(ExistId constraintAnnotation) {
        this.entity = constraintAnnotation.entity();
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        Query query = em.createQuery("Select 1 from " + entity.getName() + " where id = :value");

        query.setParameter("value", value);

        List<?> result = query.getResultList();
        boolean isValid = !result.isEmpty();

        return isValid;
    }
}
