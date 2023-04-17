package Ignite.Park.Go.domain.estacionamento;

public record DadosAtualizacaoEstacionamento(
        Long id,
        String nome,
        String telefoneEmpresa,
        String diaFuncionamento,
        String horarioFuncionamento
) {
    public DadosAtualizacaoEstacionamento(Estacionamento estacionamento) {
        this(estacionamento.getId(), estacionamento.getNome(), estacionamento.getTelefoneEmpresa(),
                estacionamento.getDiaFuncionamento(), estacionamento.getHorarioFuncionamento());
    }
}
