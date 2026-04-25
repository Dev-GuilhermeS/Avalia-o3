package br.edu.ifsp.mecanica.conserto;

import br.edu.ifsp.mecanica.veiculo.Veiculo;
import br.edu.ifsp.mecanica.mecanico.Mecanico;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroConserto(

        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}")
        String dataEntrada,

        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}")
        String dataSaida,

        @Valid
        Veiculo veiculo,

        @Valid
        Mecanico mecanico

) {}