package Ignite.Park.Go.domain.cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroCliente(
        @NotBlank(message = "{}")
        String nome,
        @NotBlank(message = "{}")
        @Email(message = "{}")
        String email,
        @NotBlank(message = "{}")
        @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2}")
        String cpf,
        String dataNascimento,
        String telefone
) {
}
