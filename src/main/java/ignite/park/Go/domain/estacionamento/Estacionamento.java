package Ignite.Park.Go.domain.estacionamento;

import Ignite.Park.Go.domain.endereco.Endereco;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Estacionamento")
@Table(name = "estacionamentos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Estacionamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cnpj;
    private String telefoneEmpresa;

    @Embedded
    private Endereco endereco;
    private String diaFuncionamento;
    private String horarioFuncionamento;
    private Boolean ativo;

    public Estacionamento(DadosCadastroEstacionamento dados) {
        this.nome = dados.nome();
        this.cnpj = dados.cnpj();
        this.telefoneEmpresa = dados.telefoneEmpresa();
        this.endereco = new Endereco(dados.endereco());
        this.diaFuncionamento = dados.diaFuncionamento();
        this.horarioFuncionamento = dados.horarioFuncionamento();
        this.ativo = true;
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoEstacionamento dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefoneEmpresa() != null) {
            this.telefoneEmpresa = dados.telefoneEmpresa();
        }
        if (dados.diaFuncionamento() != null) {
            this.diaFuncionamento = dados.diaFuncionamento();
        }
        if (dados.horarioFuncionamento() != null) {
            this.horarioFuncionamento = dados.horarioFuncionamento();
        }
    }

    public void inativar() {
        this.ativo = false;
    }
}
