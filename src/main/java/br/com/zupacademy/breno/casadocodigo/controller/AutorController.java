package br.com.zupacademy.breno.casadocodigo.controller;

import br.com.zupacademy.breno.casadocodigo.controller.form.AutorRequest;
import br.com.zupacademy.breno.casadocodigo.controller.validator.ProibeEmailDuplicadoAutorValidator;
import br.com.zupacademy.breno.casadocodigo.modelo.Autor;
import br.com.zupacademy.breno.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void cadastrar(@Valid @RequestBody AutorRequest request) {
        Autor autor = request.toModel();
        repository.save(autor);
    }
}
