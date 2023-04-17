package Ignite.Park.Go.domain.estacionamento;

import Ignite.Park.Go.domain.endereco.Endereco;

public record DadosDetalhamentoEstacionamento(
        Long id,
        String nome,
        String cnpj,
        String telefoneEmpresa,
        String diaFuncionamento,
        String horarioFuncionamento,
        Endereco endereco
) {
    public DadosDetalhamentoEstacionamento(Estacionamento estacionamento) {
        this(estacionamento.getId(), estacionamento.getNome(), estacionamento.getCnpj(), estacionamento.getTelefoneEmpresa(), estacionamento.getDiaFuncionamento(),
                estacionamento.getHorarioFuncionamento(), estacionamento.getEndereco());
    }
}
