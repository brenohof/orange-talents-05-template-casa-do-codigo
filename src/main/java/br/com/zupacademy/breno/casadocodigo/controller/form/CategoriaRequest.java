package br.com.zupacademy.breno.casadocodigo.controller.form;

import br.com.zupacademy.breno.casadocodigo.controller.validator.IfExists;
import br.com.zupacademy.breno.casadocodigo.model.Categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {
    @NotBlank @IfExists(entity = Categoria.class, field = "nome")
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
