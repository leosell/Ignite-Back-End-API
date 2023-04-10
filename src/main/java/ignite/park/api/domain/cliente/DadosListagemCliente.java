package ignite.park.api.domain.cliente;

public record DadosListagemCliente(
        Long id,
        String nome,
        String email,
        String dataNascimento) {
    public DadosListagemCliente(Cliente cliente) {
        this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getDataNascimento());
    }
}
