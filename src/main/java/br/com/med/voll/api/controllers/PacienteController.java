package br.com.med.voll.api.controllers;

import br.com.med.voll.api.dto.DadosAtualizaPaciente;
import br.com.med.voll.api.dto.DadosListagemPacienteDTO;
import br.com.med.voll.api.dto.DadosPacienteDTO;
import br.com.med.voll.api.model.Paciente;
import br.com.med.voll.api.repositories.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarPaciente(@RequestBody @Valid DadosPacienteDTO dados){
        repository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<DadosListagemPacienteDTO> listarPacientes(@PageableDefault(size = 10, page = 0, sort = {"nome"}) Pageable pageable){
        return repository.findAll(pageable).map(DadosListagemPacienteDTO::new);
    }

    @PutMapping
    @Transactional
    public void atualizaPaceite(@RequestBody @Valid DadosAtualizaPaciente dados){
        Paciente paciente = repository.getReferenceById(dados.id());
        paciente.atualizaDadosPaciente(dados);
    }
}
