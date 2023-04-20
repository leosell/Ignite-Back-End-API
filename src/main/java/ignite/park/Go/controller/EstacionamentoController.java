package Ignite.Park.Go.controller;

import Ignite.Park.Go.domain.estacionamento.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@CrossOrigin("*")
@RequestMapping("/estacionamento")
public class EstacionamentoController {

    @Autowired
    private EstacionamentoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroEstacionamento dados, UriComponentsBuilder uriBuilder) {
        var estacionamento = new Estacionamento(dados);

        repository.save(estacionamento);

        var uri = uriBuilder.path("/estacionamento/{id}").buildAndExpand(estacionamento.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoEstacionamento(estacionamento));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemEstacionamento>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemEstacionamento::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoEstacionamento dados){
        var estacionamento = repository.getReferenceById(dados.id());
        estacionamento.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoEstacionamento(estacionamento));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity inativar(@PathVariable Long id) {
        var estacionamento = repository.getReferenceById(id);
        estacionamento.inativar();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var estacionamento = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoEstacionamento(estacionamento));
    }
}
