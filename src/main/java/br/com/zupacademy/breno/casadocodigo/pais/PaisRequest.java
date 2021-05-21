package br.com.zupacademy.breno.casadocodigo.pais;

import br.com.zupacademy.breno.casadocodigo.validator.UniqueValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class PaisRequest {
    @NotBlank @UniqueValue(entity = Pais.class, field = "nome")
    private String nome;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public PaisRequest(String nome) {
        this.nome = nome;
    }

    public Pais toModel() {
        return new Pais(nome);
    }
}
