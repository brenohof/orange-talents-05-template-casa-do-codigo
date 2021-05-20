package br.com.zupacademy.breno.casadocodigo.categoria;

import br.com.zupacademy.breno.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {
    @NotBlank @UniqueValue(entity = Categoria.class, field = "nome")
    private String nome;

    public Categoria toModel() {
        return new Categoria(nome);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }
}
