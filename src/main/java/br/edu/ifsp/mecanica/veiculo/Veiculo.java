package br.edu.ifsp.mecanica.veiculo;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.*;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {

    @NotBlank
    private String marca;

    @NotBlank
    private String modelo;

    @Pattern(regexp = "\\d{4}")
    private String ano;

    private String cor;
}
