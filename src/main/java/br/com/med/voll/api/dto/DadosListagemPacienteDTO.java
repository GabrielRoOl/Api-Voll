package br.com.med.voll.api.dto;

import br.com.med.voll.api.domain.model.Paciente;

public record DadosListagemPacienteDTO(Long id, String nome, String cpf, String telefone) {
    public DadosListagemPacienteDTO(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getCpf(), paciente.getTelefone());
    }
}
