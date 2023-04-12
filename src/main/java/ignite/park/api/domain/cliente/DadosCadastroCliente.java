package ignite.park.api.domain.cliente;

import ignite.park.api.domain.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroCliente(

    @NotBlank(message = "{nome.obrigatorio}")
    String nome,

    @NotBlank(message = "{email.obrigatorio}")
    @Email(message = "{email.invalido}")
    String email,

    @NotBlank(message = "{cpf.obrigatorio}")
    @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}")
    String cpf,

//    @NotBlank(message = "{dataNascimento.obrigatorio}")
    String dataNascimento,

//    @NotBlank(message = "{telefone.obrigatorio}")
    String telefone,

//    @NotNull(message = "{endereco.obrigatorio}")
//    @Valid
//    DadosEndereco endereco,

    @NotBlank(message = "{password.obrigatorio}")
    String password
) {

}
