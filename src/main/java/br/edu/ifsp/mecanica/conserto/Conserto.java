package br.edu.ifsp.mecanica.conserto;

import br.edu.ifsp.mecanica.veiculo.Veiculo;
import br.edu.ifsp.mecanica.mecanico.Mecanico;
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

    @Column(nullable = false)
    private Boolean ativo;

    public Conserto(String dataEntrada, String dataSaida,
                    Veiculo veiculo, Mecanico mecanico) {

        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.veiculo = veiculo;
        this.mecanico = mecanico;
        this.ativo = true;
    }
}