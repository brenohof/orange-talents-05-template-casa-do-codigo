package br.com.zupacademy.breno.casadocodigo.autor;

import br.com.zupacademy.breno.casadocodigo.validator.UniqueValue;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class AutorRequest {
    @NotBlank
    private String nome;
    @NotBlank @Email @UniqueValue(entity = Autor.class, field = "email")
    private String email;
    @NotBlank @Length(max=400)
    private String descricao;

    public AutorRequest(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor toModel() {
        return new Autor(nome, email, descricao);
    }

    public String getEmail() {
        return this.email;
    }
}
