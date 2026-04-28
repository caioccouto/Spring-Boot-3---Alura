package med.voll.api.controller;


import jakarta.validation.Valid;
import med.voll.api.medicos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosMedicos dadosMedicos){
        repository.save(new Medico(dadosMedicos));
    }

    @GetMapping
    public Page<DadosListagemMedicos> listar(Pageable pageable){
        return repository.findAllByAtivoTrue(pageable).map(DadosListagemMedicos::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedicos dadosMedicos){
        Medico medico = repository.getReferenceById(dadosMedicos.id());
        medico.atualizarMedicos(dadosMedicos);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void remover(@PathVariable Long id){
        Medico medico = repository.getReferenceById(id);
        medico.remover();
    }
}
