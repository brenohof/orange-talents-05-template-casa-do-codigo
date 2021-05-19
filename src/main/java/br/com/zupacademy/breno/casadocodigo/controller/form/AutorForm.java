package br.com.zupacademy.breno.casadocodigo.controller.form;

import br.com.zupacademy.breno.casadocodigo.modelo.Autor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AutorForm {
    @NotNull @NotBlank @NotEmpty
    private String nome;
    @NotNull @NotBlank @NotEmpty @Email
    @Column(unique = true)
    private String email;
    @NotNull @NotBlank @NotEmpty @Length(max=400)
    private String descricao;

    public AutorForm(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor converter() {
        return new Autor(nome, email, descricao);
    }
}
