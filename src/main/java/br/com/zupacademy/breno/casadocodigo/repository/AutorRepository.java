package br.com.zupacademy.breno.casadocodigo.repository;

import br.com.zupacademy.breno.casadocodigo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    public Optional<Autor> findByEmail(@Email @NotBlank String email);
}
