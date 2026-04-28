package med.voll.api.medicos;

import med.voll.api.enderecos.Endereco;

public record DadosDetalhamentoMedico(Long id, String nome, String email, String telefone, String crm, Especialidade especialidade, Endereco endereco) {

    public DadosDetalhamentoMedico(Medico m){
        this(m.getId(), m.getNome(), m.getEmail(), m.getTelefone(), m.getCrm(), m.getEspecialidade(), m.getEndereco());
    }
}
