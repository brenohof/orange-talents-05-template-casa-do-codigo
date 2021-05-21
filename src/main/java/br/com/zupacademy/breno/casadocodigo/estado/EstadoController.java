package br.com.zupacademy.breno.casadocodigo.estado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoController {
    @Autowired
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@Valid @RequestBody EstadoRequest request) {
        @Valid Estado estado = request.toModel(entityManager);
        entityManager.persist(estado);
        return ResponseEntity.ok().build();
    }
}
