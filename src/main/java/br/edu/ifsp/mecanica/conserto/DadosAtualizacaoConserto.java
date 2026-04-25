package br.edu.ifsp.mecanica.conserto;

public record DadosAtualizacaoConserto(
        String dataSaida,
        String nomeMecanico,
        Integer anosExperiencia
) {}