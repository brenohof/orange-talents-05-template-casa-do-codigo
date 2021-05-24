package br.com.zupacademy.breno.casadocodigo.cliente;

import br.com.zupacademy.breno.casadocodigo.estado.Estado;
import br.com.zupacademy.breno.casadocodigo.pais.Pais;
import br.com.zupacademy.breno.casadocodigo.validator.ExistId;
import br.com.zupacademy.breno.casadocodigo.validator.UniqueValue;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteRequest {
    @NotBlank @Email @UniqueValue(entity = Cliente.class, field = "email")
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @CPF @UniqueValue(entity = Cliente.class, field = "documento")
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull @ExistId(entity = Pais.class)
    private Long paisId;
    private Long estadoId;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    public ClienteRequest(String email, String nome, String sobrenome, String documento, String endereco,
                          String complemento, String cidade, Long paisId, Long estadoId, String telefone,
                          String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.paisId = paisId;
        this.estadoId = estadoId;
        this.telefone = telefone;
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public Cliente toModel(EntityManager entityManager) {
        Pais pais = entityManager.find(Pais.class, paisId);

        Assert.state(pais != null, "Você esta querendo cadastrar um cliente para um pais que nao existe no banco "+paisId);

        Query query = entityManager.createQuery("from Estado where pais_id = :id");
        query.setParameter("id", paisId);

        if (query.getResultList().isEmpty())
            return new Cliente(this, pais);

        Estado estado = entityManager.find(Estado.class, estadoId);

        Assert.state(estado != null, "Você esta querendo cadastrar um cliente para um estado que nao existe no banco "+estadoId);

        if (estado != null && estado.pertence(pais))
            return new Cliente(this, pais, estado);

        return null;
    }
}
