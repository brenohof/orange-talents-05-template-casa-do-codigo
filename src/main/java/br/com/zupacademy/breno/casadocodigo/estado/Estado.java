package br.com.zupacademy.breno.casadocodigo.estado;

import br.com.zupacademy.breno.casadocodigo.pais.Pais;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "estados")
public class Estado {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Valid @NotNull @ManyToOne
    private Pais pais;
    @NotNull @NotBlank @Column(unique = true)
    private String nome;


    @Deprecated
    public Estado() {}

    public Estado(@NotNull Pais pais,@NotBlank String nome) {
        this.pais = pais;
        this.nome = nome;
    }

    public boolean pertence(Pais pais) {
        if (this.pais.getId() == pais.getId())
            return true;
        return  false;
    }
}
