package br.edu.ifsp.mecanica.conserto;

public record DadosListagemConserto(
        Long id,
        String dataEntrada,
        String dataSaida,
        String nomeMecanico,
        String marca,
        String modelo
) {}
