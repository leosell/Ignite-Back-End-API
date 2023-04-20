package Ignite.Park.Go.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosAutenticacao(
        String login,
        @NotBlank(message = "{senha.obrigatorio}")
        String senha
) {
}
