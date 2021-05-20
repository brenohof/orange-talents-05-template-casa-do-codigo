package br.com.zupacademy.breno.casadocodigo.livro;

import br.com.zupacademy.breno.casadocodigo.autor.Autor;
import br.com.zupacademy.breno.casadocodigo.categoria.Categoria;
import br.com.zupacademy.breno.casadocodigo.validator.ExistId;
import br.com.zupacademy.breno.casadocodigo.validator.UniqueValue;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.time.LocalDate;

public class LivroRequest {
    @NotBlank @UniqueValue(entity = Livro.class, field = "titulo")
    private String titulo;
    @NotBlank @Size(max=500)
    private String resumo;
    @NotBlank
    private String sumario;
    @NotNull @Positive @Min(20)
    private Double preco;
    @NotNull @Min(100) @Positive
    private Integer numeroDePaginas;
    @NotNull @Future
    @DateTimeFormat(pattern="yyyyMMdd")
    private LocalDate dataDePublicacao;
    @NotNull @ExistId(entity = Autor.class)
    private Long autorId;
    @NotNull @ExistId(entity = Categoria.class)
    private Long categoriaId;

    public LivroRequest(String titulo, String resumo, String sumario, Double preco, Integer numeroDePaginas, LocalDate dataDePublicacao, Long autorId, Long categoriaId) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.dataDePublicacao = dataDePublicacao;
        this.autorId = autorId;
        this.categoriaId = categoriaId;
    }

    public Livro toModel(EntityManager entityManager) {
        Categoria categoria = entityManager.find(Categoria.class, categoriaId);
        Autor autor = entityManager.find(Autor.class, autorId);
        return new Livro(titulo, resumo, sumario, preco, numeroDePaginas, dataDePublicacao, categoria, autor);
    }
}
