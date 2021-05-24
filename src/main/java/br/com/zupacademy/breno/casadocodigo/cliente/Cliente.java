package br.com.zupacademy.breno.casadocodigo.cliente;

import br.com.zupacademy.breno.casadocodigo.estado.Estado;
import br.com.zupacademy.breno.casadocodigo.pais.Pais;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Email
    @NotNull @Column(unique = true)
    private String email;
    @NotNull @NotBlank
    private String nome;
    @NotNull @NotBlank
    private String sobrenome;
    @NotNull @CPF @Column(unique = true)
    private String documento;
    @NotNull @NotBlank
    private String endereco;
    @NotNull @NotBlank
    private String complemento;
    @NotNull @NotBlank
    private String cidade;
    @NotNull @ManyToOne
    private Pais pais;
    @ManyToOne
    private Estado estado;
    @NotNull @NotBlank
    private String telefone;
    @NotNull @NotBlank
    private String cep;

    public Cliente(ClienteRequest cliente, Pais pais) {
        this(cliente, pais, null);
    }

    public Cliente(ClienteRequest cliente, Pais pais, Estado estado) {
        this.email = cliente.getEmail();
        this.nome = cliente.getNome();
        this.sobrenome = cliente.getSobrenome();
        this.documento = cliente.getDocumento();
        this.endereco = cliente.getEndereco();
        this.complemento = cliente.getComplemento();
        this.cidade = cliente.getCidade();
        this.pais = pais;
        this.estado = estado;
        this.telefone = cliente.getTelefone();
        this.cep = cliente.getCep();
    }

    public Long getId() {
        return this.id;
    }
}
