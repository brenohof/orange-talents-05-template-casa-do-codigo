package br.com.zupacademy.breno.casadocodigo.livro;

import br.com.zupacademy.breno.casadocodigo.autor.Autor;
import br.com.zupacademy.breno.casadocodigo.categoria.Categoria;
import br.com.zupacademy.breno.casadocodigo.validator.ExistId;
import br.com.zupacademy.breno.casadocodigo.validator.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.time.LocalDate;

public class LivroRequest {
    @NotBlank @UniqueValue(entity = Livro.class, field = "titulo")
    private String isbn;
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
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataDePublicacao;
    @NotNull @ExistId(entity = Autor.class)
    private Long autorId;
    @NotNull @ExistId(entity = Categoria.class)
    private Long categoriaId;


    /**
     * Apenas para que o Jackson consiga fazer o parser do pattern de data.
     */
    public void setDataDePublicacao(LocalDate dataDePublicacao) {
        this.dataDePublicacao = dataDePublicacao;
    }

    public LivroRequest(String isbn, String titulo, String resumo, String sumario, Double preco,
                        Integer numeroDePaginas, Long autorId,
                        Long categoriaId) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.autorId = autorId;
        this.categoriaId = categoriaId;
    }

    public Livro toModel(EntityManager entityManager) {
        @NotNull Categoria categoria = entityManager.find(Categoria.class, categoriaId);
        @NotNull Autor autor = entityManager.find(Autor.class, autorId);

        Assert.state(autor!=null,"Você esta querendo cadastrar um livro para um autor que nao existe no banco "+autorId);
        Assert.state(categoria!=null,"Você esta querendo cadastrar um livro para uma categoria que nao existe no banco "+categoriaId);

        return new Livro(isbn, titulo, resumo, sumario, preco, numeroDePaginas, dataDePublicacao, categoria, autor);
    }
}
