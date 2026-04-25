package br.edu.ifsp.mecanica.mecanico;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {

    @NotBlank
    private String nome;

    private Integer anosExperiencia;
}
