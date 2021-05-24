package br.com.zupacademy.breno.casadocodigo.estado;

import br.com.zupacademy.breno.casadocodigo.autor.Autor;
import br.com.zupacademy.breno.casadocodigo.categoria.Categoria;
import br.com.zupacademy.breno.casadocodigo.pais.Pais;
import br.com.zupacademy.breno.casadocodigo.validator.ExistId;
import br.com.zupacademy.breno.casadocodigo.validator.UniqueValue;
import org.springframework.util.Assert;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.Query;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class EstadoRequest {
    @NotBlank
    private String nome;
    @NotNull @Positive @ExistId(entity = Pais.class)
    private Long paisId;

    public EstadoRequest(String nome, Long paisId) {
        this.nome = nome;
        this.paisId = paisId;
    }

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Estado toModel(EntityManager entityManager) {
        @NotNull Pais pais = entityManager.find(Pais.class, paisId);

        Assert.state(pais != null, "Você esta querendo cadastrar um estado para um pais que nao existe no banco "+paisId);

        return new Estado(pais, nome);
    }
}