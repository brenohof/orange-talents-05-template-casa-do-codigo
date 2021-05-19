package br.com.zupacademy.breno.casadocodigo.controller.validator;

import br.com.zupacademy.breno.casadocodigo.controller.form.CategoriaRequest;
import br.com.zupacademy.breno.casadocodigo.modelo.Categoria;
import br.com.zupacademy.breno.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeCategoriaDuplicadaValidator implements Validator {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return CategoriaRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors())
            return;

        CategoriaRequest request = (CategoriaRequest) target;
        Optional<Categoria> optional = categoriaRepository.findByNome(request.getNome());

        if (optional.isPresent()) {
            errors.rejectValue("nome", null,
                    "Já existe uma outra categoria com o mesmo nome"
                            + request.getNome());
        }
    }
}
