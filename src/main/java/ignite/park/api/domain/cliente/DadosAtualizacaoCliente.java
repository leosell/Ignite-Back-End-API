package ignite.park.api.domain.cliente;

import ignite.park.api.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCliente(
    @NotNull
    Long id,
    String nome,
    String telefone,
    DadosEndereco endereco,
    String password
) {}
