package ignite.park.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import ignite.park.api.domain.estacionamento.DadosAtualizacaoEstacionamento;
import ignite.park.api.domain.estacionamento.DadosCadastroEstacionamento;
import ignite.park.api.domain.estacionamento.DadosDetalhamentoEstacionamento;
import ignite.park.api.domain.estacionamento.DadosListagemEstacionamento;
import ignite.park.api.domain.estacionamento.Estacionamento;
import ignite.park.api.domain.estacionamento.EstacionamentoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
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
