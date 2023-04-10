package ignite.park.api.domain.cliente;

import ignite.park.api.domain.endereco.Endereco;

public record DadosDetalhamentoCliente(Long id, String nome, String email, String cpf, String dataNascimento,
        String telefone, Endereco endereco) {
    public DadosDetalhamentoCliente(Cliente cliente) {
        this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getCpf(), cliente.getDataNascimento(),
                cliente.getTelefone(), cliente.getEndereco());
    }
}
