package Ignite.Park.Go.controller;

import Ignite.Park.Go.domain.cliente.*;
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
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroCliente dados, UriComponentsBuilder uriBuilder) {
        var cliente = new Cliente(dados);

        clienteRepository.save(cliente);

        var uri = uriBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoCliente(cliente));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemCliente>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = clienteRepository.findAllByAtivoTrue(paginacao).map(DadosListagemCliente::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoCliente dados){
        var cliente = clienteRepository.getReferenceById(dados.id());
        cliente.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoCliente(cliente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity inativar(@PathVariable Long id) {
        var cliente = clienteRepository.getReferenceById(id);
        cliente.inativar();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var cliente = clienteRepository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoCliente(cliente));
    }
}
