package ignite.park.api.domain.cliente;

import jakarta.validation.constraints.NotNull;

public record DadosAutenticacaoCliente(@NotNull String email, String password) {
}
