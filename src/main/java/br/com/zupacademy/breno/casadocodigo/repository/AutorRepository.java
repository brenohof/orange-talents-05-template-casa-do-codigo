package br.com.zupacademy.breno.casadocodigo.repository;

import br.com.zupacademy.breno.casadocodigo.modelo.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
}
