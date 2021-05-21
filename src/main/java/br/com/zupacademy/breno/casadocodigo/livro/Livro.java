package br.com.zupacademy.breno.casadocodigo.livro;

import br.com.zupacademy.breno.casadocodigo.autor.Autor;
import br.com.zupacademy.breno.casadocodigo.categoria.Categoria;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "livros")
public class Livro {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @Column(unique = true)
    private @NotBlank String isbn;
    @NotNull @Column(unique = true)
    private String titulo;
    @NotNull @Size(max=500)
    private String resumo;
    @NotNull
    private String sumario;
    @NotNull @Positive @Min(20)
    private Double preco;
    @NotNull @Min(100) @Positive
    private Integer numeroDePaginas;
    @NotNull @Future
    private LocalDate dataDePublicacao;
    @NotNull @ManyToOne
    private @Valid Categoria categoria;
    @NotNull @ManyToOne
    private @Valid Autor autor;

    @Deprecated
    public Livro() {
    }

    /**
     * @param isbn é obrigatório e único.
     * @param titulo é obrigatório e único.
     * @param resumo é obrigatório e no máximo 500 caracteres.
     * @param sumario é de tamanho livre.
     * @param preco o valor mínimo é 20.
     * @param numeroDePaginas o número mínimo é 100.
     * @param dataDePublicacao precisa ser uma data no futuro.
     * @param categoria não pode ser nulo.
     * @param autor não pode ser nulo.
     */
    public Livro(String isbn, String titulo, String resumo, String sumario, Double preco, Integer numeroDePaginas, LocalDate dataDePublicacao, Categoria categoria, Autor autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.dataDePublicacao = dataDePublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
