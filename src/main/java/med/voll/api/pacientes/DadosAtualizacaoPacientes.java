package med.voll.api.pacientes;

import jakarta.validation.constraints.NotNull;
import med.voll.api.enderecos.Endereco;

public record DadosAtualizacaoPacientes(

        @NotNull
        Long id,
        String nome,
        String email,
        Endereco endereco) {
}
