package Ignite.Park.Go.domain.estacionamento;

import Ignite.Park.Go.domain.endereco.Endereco;

public record DadosListagemEstacionamento(
        Long id,
        String nome,
        String diaFuncionamento,
        String horarioFuncionamento,
        Endereco endereco
) {
    public DadosListagemEstacionamento(Estacionamento estacionamento) {
        this(estacionamento.getId(), estacionamento.getNome(), estacionamento.getDiaFuncionamento(),
                estacionamento.getHorarioFuncionamento(), estacionamento.getEndereco());
    }
}
