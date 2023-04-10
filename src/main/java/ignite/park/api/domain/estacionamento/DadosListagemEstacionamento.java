package ignite.park.api.domain.estacionamento;

import ignite.park.api.domain.endereco.Endereco;

public record DadosListagemEstacionamento(Long id, String nome, String diaFuncionamento, String horarioFuncionamento,
        Endereco endereco) {
    public DadosListagemEstacionamento(Estacionamento estacionamento) {
        this(estacionamento.getId(), estacionamento.getNome(), estacionamento.getDiaFuncionamento(),
                estacionamento.getHorarioFuncionamento(), estacionamento.getEndereco());
    }
}
