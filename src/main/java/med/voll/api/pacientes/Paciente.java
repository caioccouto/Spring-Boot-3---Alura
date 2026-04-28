package med.voll.api.pacientes;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.enderecos.Endereco;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;

    @Embedded
    private Endereco endereco;

    private boolean ativo;

    public Paciente(DadosPacientes dp){
        this.nome = dp.nome();
        this.email = dp.email();
        this.cpf = dp.cpf();
        this.telefone = dp.telefone();
        this.endereco = new Endereco(dp.endereco());
        this.ativo = true;
    }

    public void atualizarPaciente(@Valid DadosAtualizacaoPacientes dadosPaciente) {
        if (dadosPaciente.nome() != null){
            this.nome = dadosPaciente.nome();
        }

        if (dadosPaciente.email() != null){
            this.email = dadosPaciente.email();
        }

        if (dadosPaciente.endereco() != null){
            this.endereco = dadosPaciente.endereco();
        }
    }

    public void removerPaciente() {
        this.ativo = false;
    }
}
