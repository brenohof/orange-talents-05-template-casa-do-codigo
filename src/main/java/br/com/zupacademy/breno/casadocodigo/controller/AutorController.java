package br.com.zupacademy.breno.casadocodigo.controller;

import br.com.zupacademy.breno.casadocodigo.controller.form.AutorRequest;
import br.com.zupacademy.breno.casadocodigo.model.Autor;
import br.com.zupacademy.breno.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository repository;

    @PostMapping
    public ResponseEntity<?> cadastrar(@Valid @RequestBody AutorRequest request) {
        Autor autor = request.toModel();
        repository.save(autor);
        return ResponseEntity.ok().build();
    }
}
