package Ignite.Park.Go.domain.estacionamento;

import Ignite.Park.Go.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroEstacionamento(
        @NotBlank(message = "{nome.obrigatorio}")
        String nome,

        @NotBlank(message = "{cnpj.obrigatorio}")
        String cnpj,

        @NotBlank(message = "{telefone.obrigatorio}")
        String telefoneEmpresa,

        @NotNull(message = "{endereco.obrigatorio}")
        DadosEndereco endereco,

        @NotBlank(message = "{diaFuncionamento.obrigatorio}")
        String diaFuncionamento,

        @NotBlank(message = "{horarioFuncionamento.obrigatorio}")
        String horarioFuncionamento
) {
}
