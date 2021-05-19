package br.com.zupacademy.breno.casadocodigo.controller.validator;

import br.com.zupacademy.breno.casadocodigo.controller.form.AutorForm;
import br.com.zupacademy.breno.casadocodigo.modelo.Autor;
import br.com.zupacademy.breno.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return AutorForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors())
            return;

        AutorForm request = (AutorForm) target;
        Optional<Autor> optional = autorRepository.findByEmail(request.getEmail());

        if (optional.isPresent()) {
            errors.rejectValue("email", null,
                    "Já existe um(a) outro(a) autor(a) com o mesmo email"
                            + request.getEmail());
        }
    }
}
