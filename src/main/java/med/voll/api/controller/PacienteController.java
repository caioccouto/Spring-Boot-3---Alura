package med.voll.api.controller;


import jakarta.validation.Valid;
import med.voll.api.pacientes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosPacientes dadosPacientes){
        repository.save(new Paciente(dadosPacientes));
    }

    @GetMapping
    public Page<DadosListagemPaciente> listar(Pageable pageable){
        return repository.findAllByAtivoTrue(pageable).map(DadosListagemPaciente::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoPacientes dadosPacientes){
        Paciente paciente = repository.getReferenceById(dadosPacientes.id());
        paciente.atualizarPaciente(dadosPacientes);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void remover(@PathVariable Long id){
        Paciente paciente = repository.getReferenceById(id);
        paciente.removerPaciente();
    }
}
