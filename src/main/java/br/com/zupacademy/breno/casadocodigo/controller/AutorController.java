package br.com.zupacademy.breno.casadocodigo.controller;

import br.com.zupacademy.breno.casadocodigo.controller.form.AutorForm;
import br.com.zupacademy.breno.casadocodigo.controller.validator.ProibeEmailDuplicadoAutorValidator;
import br.com.zupacademy.breno.casadocodigo.modelo.Autor;
import br.com.zupacademy.breno.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository repository;

    @Autowired
    private ProibeEmailDuplicadoAutorValidator proibeEmailDuplicadoAutorValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(proibeEmailDuplicadoAutorValidator);
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@Valid @RequestBody AutorForm form) {
        Autor autor = form.toModel();
        repository.save(autor);
        return ResponseEntity.ok().build();
    }
}
