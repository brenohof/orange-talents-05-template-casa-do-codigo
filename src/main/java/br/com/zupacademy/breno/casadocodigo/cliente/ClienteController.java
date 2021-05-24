package br.com.zupacademy.breno.casadocodigo.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@Valid @RequestBody ClienteRequest request) {
        Cliente cliente = request.toModel(entityManager);

        if (cliente == null)
            return ResponseEntity.badRequest().build();

        entityManager.persist(cliente);
        String resposta = "{\n \"id\": \"" + cliente.getId() + "\"\n}";
        return ResponseEntity.ok(resposta);
    }
}
