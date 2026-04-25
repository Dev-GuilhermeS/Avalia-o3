package br.edu.ifsp.mecanica.controller;

import br.edu.ifsp.mecanica.conserto.*;
import jakarta.validation.Valid;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consertos")
public class ConsertoController {

    private final ConsertoRepository repository;

    public ConsertoController(ConsertoRepository repository) {
        this.repository = repository;
    }


    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroConserto dados){

        Conserto conserto = new Conserto(
                dados.dataEntrada(),
                dados.dataSaida(),
                dados.veiculo(),
                dados.mecanico()
        );

        repository.save(conserto);

        return ResponseEntity.status(201).body(conserto);
    }
    @GetMapping
    public ResponseEntity<Page<Conserto>> listar(Pageable pageable){
        return ResponseEntity.ok(repository.findAll(pageable));
    }

    @GetMapping("/resumo")
    public ResponseEntity<List<DadosListagemConserto>> listarResumo(){
        return ResponseEntity.ok(repository.listarResumo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conserto> buscarPorId(@PathVariable Long id){

        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(
            @PathVariable Long id,
            @RequestBody DadosAtualizacaoConserto dados){

        var conserto = repository.findById(id);

        if(conserto.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Conserto c = conserto.get();

        c.setDataSaida(dados.dataSaida());
        c.getMecanico().setNome(dados.nomeMecanico());
        c.getMecanico().setAnosExperiencia(dados.anosExperiencia());

        repository.save(c);

        return ResponseEntity.ok(c);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id){

        var conserto = repository.findById(id);

        if(conserto.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Conserto c = conserto.get();
        c.setAtivo(false);

        repository.save(c);

        return ResponseEntity.noContent().build();
    }
}