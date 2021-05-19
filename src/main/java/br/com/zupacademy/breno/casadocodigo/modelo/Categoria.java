package br.com.zupacademy.breno.casadocodigo.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "categorias")
public class Categoria {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @NotBlank
    private String nome;

    @Deprecated
    public Categoria() { }

    /**
     * @param nome Campo obrigatório.
     */
    public Categoria(@NotBlank String nome) {
        this.nome = nome;
    }
}
