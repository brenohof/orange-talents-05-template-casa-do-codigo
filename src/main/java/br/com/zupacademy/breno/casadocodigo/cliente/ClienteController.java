package br.com.zupacademy.breno.casadocodigo.cliente;

import br.com.zupacademy.breno.casadocodigo.validator.EstadoPertenceAPaisValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    EntityManager entityManager;

    @Autowired
    private EstadoPertenceAPaisValidator estadoPertenceAPaisValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(estadoPertenceAPaisValidator);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@Valid @RequestBody ClienteRequest request) {
        Cliente cliente = request.toModel(entityManager);
        entityManager.persist(cliente);
        String resposta = "{\n \"id\": \"" + cliente.getId() + "\"\n}";
        return ResponseEntity.ok(resposta);
    }
}
