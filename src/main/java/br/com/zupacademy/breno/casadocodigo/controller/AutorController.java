package br.com.zupacademy.breno.casadocodigo.controller;

import br.com.zupacademy.breno.casadocodigo.controller.form.AutorForm;
import br.com.zupacademy.breno.casadocodigo.modelo.Autor;
import br.com.zupacademy.breno.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository repository;

    @PostMapping
    public ResponseEntity<?> cadastrar(@Valid @RequestBody AutorForm form) {
        Autor autor = form.toModel();
        repository.save(autor);
        return ResponseEntity.ok().build();
    }
}
