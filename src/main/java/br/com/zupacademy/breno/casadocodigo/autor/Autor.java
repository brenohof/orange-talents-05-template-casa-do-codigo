package br.com.zupacademy.breno.casadocodigo.autor;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "autores")
public class Autor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @NotBlank
    private String nome;
    @NotNull @NotBlank @Email @Column(unique = true)
    private String email;
    @NotNull @NotBlank @Length(max=400)
    private String descricao;
    @NotNull
    private final LocalDateTime momentoDeRegistro = LocalDateTime.now();

    @Deprecated
    public Autor() {
    }

    /**
     * @param nome não deve ser nulo, vazio ou em branco.
     * @param email não deve ser nulo, vazio ou em branco. Deve estar no formato de email e ser único.
     * @param descricao não deve ser nulo, vazio, em branco ou possuir mais do que 400 caracteres.
     */
    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }
}
