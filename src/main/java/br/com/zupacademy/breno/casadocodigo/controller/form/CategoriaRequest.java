package br.com.zupacademy.breno.casadocodigo.controller.form;

import br.com.zupacademy.breno.casadocodigo.modelo.Categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {
    @NotBlank
    private String nome;

    public CategoriaRequest(@NotBlank String nome) {
        this.nome = nome;
    }

    public Categoria toModel() {
        return new Categoria(nome);
    }

    public String getNome() {
        return this.nome;
    }
}
