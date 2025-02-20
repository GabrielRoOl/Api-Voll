package br.com.med.voll.api.controllers;

import br.com.med.voll.api.dto.DadosPacienteDTO;
import br.com.med.voll.api.model.Paciente;
import br.com.med.voll.api.repositories.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("paciente")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarPaciente(@RequestBody @Valid DadosPacienteDTO dados){
        repository.save(new Paciente(dados));
    }

}
