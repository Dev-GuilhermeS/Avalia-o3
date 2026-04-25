package br.edu.ifsp.mecanica.conserto;

import br.edu.ifsp.projeto.veiculo.Veiculo;
import br.edu.ifsp.projeto.mecanico.Mecanico;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "consertos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Conserto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dataEntrada;
    private String dataSaida;

    @Embedded
    private Veiculo veiculo;

    @Embedded
    private Mecanico mecanico;
}
