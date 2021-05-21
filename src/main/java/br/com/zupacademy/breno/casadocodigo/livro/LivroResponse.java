package br.com.zupacademy.breno.casadocodigo.livro;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

public class LivroResponse {
    private Long id;
    private String titulo;

    public LivroResponse(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public static List<LivroResponse> toModel(List<Livro> livros) {
        return livros.stream()
                .map(livro -> new LivroResponse(livro))
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
