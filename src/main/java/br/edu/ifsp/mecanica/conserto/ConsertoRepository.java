package br.edu.ifsp.mecanica.conserto;

import org.springframework.data.jpa.repository.*;
import java.util.List;

public interface ConsertoRepository extends JpaRepository<Conserto, Long> {

    @Query("""
    SELECT new br.edu.ifsp.mecanica.conserto.DadosListagemConserto(
        c.id,
        c.dataEntrada,
        c.dataSaida,
        c.mecanico.nome,
        c.veiculo.marca,
        c.veiculo.modelo
    )
    FROM Conserto c
    WHERE c.ativo = true
""")
    List<DadosListagemConserto> listarResumo();
}