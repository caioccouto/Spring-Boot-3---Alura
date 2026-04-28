package med.voll.api.medicos;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.enderecos.Endereco;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private boolean ativo;

    public Medico(DadosMedicos dadosMedicos) {
        this.nome = dadosMedicos.nome();
        this.email = dadosMedicos.email();
        this.telefone = dadosMedicos.telefone();
        this.crm = dadosMedicos.crm();
        this.especialidade = dadosMedicos.especialidade();
        this.endereco = new Endereco(dadosMedicos.endereco());
        this.ativo = true;
    }

    public void atualizarMedicos(@Valid DadosAtualizacaoMedicos dadosMedicos) {
        if (dadosMedicos.nome() != null){
            this.nome = dadosMedicos.nome();
        }

        if (dadosMedicos.email() != null){
            this.email = dadosMedicos.email();
        }

        if (dadosMedicos.endereco() != null){
            this.endereco = dadosMedicos.endereco();
        }
    }

    public void remover() {
        this.ativo = false;
    }
}
