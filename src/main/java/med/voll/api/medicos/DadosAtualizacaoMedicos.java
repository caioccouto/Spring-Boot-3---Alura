package med.voll.api.medicos;

import jakarta.validation.constraints.NotNull;
import med.voll.api.enderecos.Endereco;

public record DadosAtualizacaoMedicos(

        @NotNull
        Long id,
        String nome,
        String email,
        Endereco endereco)
{
}
