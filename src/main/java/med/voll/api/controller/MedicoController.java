package med.voll.api.controller;


import jakarta.validation.Valid;
import med.voll.api.medicos.DadosListagemMedicos;
import med.voll.api.medicos.DadosMedicos;
import med.voll.api.medicos.Medico;
import med.voll.api.medicos.MedicoRepository;
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
        return repository.findAll(pageable).map(DadosListagemMedicos::new);
    }
}
