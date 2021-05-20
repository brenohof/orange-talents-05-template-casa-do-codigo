package br.com.zupacademy.breno.casadocodigo.repository;

import br.com.zupacademy.breno.casadocodigo.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    public Optional<Categoria> findByNome(String nome);
}
