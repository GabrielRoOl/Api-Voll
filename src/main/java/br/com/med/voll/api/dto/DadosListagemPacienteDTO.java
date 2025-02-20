package br.com.med.voll.api.dto;

import br.com.med.voll.api.model.Paciente;

public record DadosListagemPacienteDTO(String nome, String cpf, String telefone) {
    public DadosListagemPacienteDTO(Paciente paciente){
        this(paciente.getNome(), paciente.getCpf(), paciente.getTelefone());
    }
}
