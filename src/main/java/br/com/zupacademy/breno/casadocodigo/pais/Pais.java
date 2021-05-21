package br.com.zupacademy.breno.casadocodigo.pais;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "paises")
public class Pais {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @NotBlank @Column(unique = true)
    private String nome;

    public Pais(@NotBlank String nome) {
        this.nome = nome;
    }

    @Deprecated
    public Pais() {}
}
