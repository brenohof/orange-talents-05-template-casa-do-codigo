package br.com.zupacademy.breno.casadocodigo.controller;

import br.com.zupacademy.breno.casadocodigo.controller.form.CategoriaRequest;
import br.com.zupacademy.breno.casadocodigo.model.Categoria;
import br.com.zupacademy.breno.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @PostMapping
    public ResponseEntity<?> cadastrar(@Valid @RequestBody CategoriaRequest request) {
        Categoria categoria = request.toModel();
        repository.save(categoria);
        return ResponseEntity.ok().build();
    }
}
