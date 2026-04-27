package med.voll.api.medicos;


public record DadosListagemMedicos(String nome, String email, String crm, Especialidade especialidade) {

    public DadosListagemMedicos(Medico m) {
        this(m.getNome(), m.getEmail(), m.getCrm(), m.getEspecialidade());
    }
}