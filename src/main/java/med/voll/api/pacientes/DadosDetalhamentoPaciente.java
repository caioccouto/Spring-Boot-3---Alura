package med.voll.api.pacientes;

import med.voll.api.enderecos.Endereco;

public record DadosDetalhamentoPaciente(Long id, String nome, String email, String cpf, String telefone, Endereco endereco) {

    public DadosDetalhamentoPaciente(Paciente p){
        this(p.getId(), p.getNome(), p.getEmail(), p.getCpf(), p.getTelefone(), p.getEndereco());
    }
}
