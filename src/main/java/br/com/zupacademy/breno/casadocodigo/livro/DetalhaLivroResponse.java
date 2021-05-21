package br.com.zupacademy.breno.casadocodigo.livro;

import java.time.LocalDate;

public class DetalhaLivroResponse {
    private String titulo;
    private String resumo;
    private String sumario;
    private String nomeAutor;
    private String descricaoAutor;
    private String nomeCategoria;
    private Double preco;
    private Integer numeroDePaginas;
    private String isbn;
    private LocalDate dataDePublicacao;

    public DetalhaLivroResponse(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroDePaginas = livro.getNumeroDePaginas();
        this.isbn = livro.getIsbn();
        this.dataDePublicacao = livro.getDataDePublicacao();
        this.nomeAutor = livro.getNomeAutor();
        this.nomeCategoria = livro.getNomeCategoria();
        this.descricaoAutor = livro.getDescricaoAutor();
    }

    public static DetalhaLivroResponse toModel(Livro livro) {
        return new DetalhaLivroResponse(livro);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public String getDescricaoAutor() {
        return descricaoAutor;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataDePublicacao() {
        return dataDePublicacao;
    }
}
