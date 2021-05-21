package br.com.zupacademy.breno.casadocodigo.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@Valid @RequestBody LivroRequest request) {
        Livro livro =  request.toModel(entityManager);
        entityManager.persist(livro);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<LivroResponse>> listar() {
        List<Livro> livros = entityManager.createQuery("from " + Livro.class.getName()).getResultList();
        return  ResponseEntity.ok(LivroResponse.toModel(livros));
    }
}
