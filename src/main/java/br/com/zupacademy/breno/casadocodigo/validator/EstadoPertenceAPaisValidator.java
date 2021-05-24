package br.com.zupacademy.breno.casadocodigo.validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.zupacademy.breno.casadocodigo.cliente.ClienteRequest;
import br.com.zupacademy.breno.casadocodigo.estado.Estado;
import br.com.zupacademy.breno.casadocodigo.pais.Pais;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EstadoPertenceAPaisValidator implements Validator{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean supports(Class<?> clazz) {
        return ClienteRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) {
            return;
        }

        ClienteRequest request = (ClienteRequest) target;

        Pais pais = manager.find(Pais.class, request.getPaisId());

        Query query = manager.createQuery("from Estado where pais_id = :id");
        query.setParameter("id", request.getPaisId());

        if (query.getResultList().isEmpty())
            return;

        Estado estado = null;

        if (request.getEstadoId() != null)
            estado = manager.find(Estado.class, request.getEstadoId());

        if(estado == null || !estado.pertence(pais)) {
            errors.rejectValue("estadoId",null,"este estado não é o do país selecionado");
        }

    }

}